/*

Implement both encoder and decoder to compress and reconstruct a sequence of 32-bit integer values that combines Run-Length and Bit-Packing encoding schemes using the provided specification and API.

Run-Length Encoding (RLE) : Encoding scheme where integers that have the same value can be represented as a single value with a count.
Example: [1, 1, 1, 1, 1] can be encoded as RLE[1, 5].

Bit-Packing (BP) : Encoding scheme where smaller integer values can be represented without using the full 4 bytes of data. For example, all numbers in 2, 3, 4, 5 fit within 3 bits, so we can encode ("pack") them into 12 bits or at most 2 bytes thus reducing data 8x.

Example: [1, 5, 2, 2, 4] can be encoded as BP[1, 5, 2, 2, 4]
Input: [1, 5, 2, 2, 40] -> 5x 32-bit integers = 20 bytes
Output: bit packed on 3 bits: 001 101 010 010 1000011 -> 15 bits = 2 bytes
=>

Run is a sequence of values that are encoded using RLE or BP. All values in a run have the same encoding but runs themselves can interleave, e.g. [RLE, BP, RLE, RLE, BP, ...].


 1. All values have to be placed into runs, and value order cannot change.
 2. A Run-Length encoded run has at least 8 values (only the last run can have
    fewer values).
 3. Once started, a Run-Length encoded run should extend as far as possible
    (it should continue as long as the input values are repeating).
 4. A Bit-Packing encoded run has exactly 8 values, i.e. once it is started,
    it is required to fill all 8 values (only the last run can have fewer values).
 5. Run-Length encoding is our default scheme.  We only use Bit-Packing encoding
    when we cannot apply Run-Length (because there is not enough repeated values).


[1, 1, 1] will be encoded as RLE[1, 3].
[1, 1, 1, 1, 2, 3, 4, 5] will be encoded as BP[1, 1, 1, 1, 2, 3, 4, 5].
[1, 1, 1, 1, 1, 1, 1, 2, 3, 4, 5] will be encoded as RLE[1, 8], BP[2, 3, 4, 5].

=> BP[1,1,1,1,1,1,1,2] BP[3,4,5]



[1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 1] will be encoded as
RLE[1,9]BP[2,3,4,5,1]


[1,1,1,2,4,1,1] => BP [1,1,1,2,4,1,1]

RLE[1,3] BP[2,4] RLe[1,2]


5 value  =>


=> 12 bit 16 bits

22 => 001000 =>



Pavan
=========

Test case
============

=>


List<Integer>

1=>

2=> bitbacking
 */

/**
 * This file contains all of the necessary code for the exercise.
 *
 * Your goal is to implement Encoder and Decoder specification by combining
 * RLE and BP encodings.
 *
 * You should implement all methods containing `// TODO` comment.
 * You may use the API helper methods and classes provided below.
 */

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class DataBricks2 {

    // Available API that you are encouraged to use

    /**
     * Represents a sequence of integer values encoded using a single encoding
     * scheme.
     *
     * The encoded data will likely consist of a mixture of `Run`s, for example,
     * [BP, BP, RLE, BP, RLE, RLE, ...].
     */
    static interface Run {}

    /**
     * Represents a sequence of integer values encoded using Run-Length encoding
     * scheme.
     */
    static class RLE implements Run {
        int value = 0; // repeated value for the Run-Length encoding
        int count = 0; // count of the `value`, at least 8 values

        public RLE(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public String toString() {
            return "RLE(" + value + "," + count + ")";
        }
    }

    /**
     * Represents a sequence of integer values encoded using Bit-Packing encoding
     * scheme.
     */
    static class BP implements Run {
        int[] data; // integer values for Bit-Packing encoding
        int count; // length of the `data` array, at most 8 values

        BP(int [] arr, int count){
            this.data = arr;
            this.count =  arr.length;
        }
        @Override
        public String toString() {
            return "BP(" + Arrays.toString(Arrays.copyOf(data, count)) + ")";
        }
    }

    // API classes and methods to implement

    public static class Encoder {
        // 1 10 , 2 , 3

        Stack<Pair<Integer, Integer>> stack;
        int count;
        List<Run> result;
        public Encoder(Stack<Pair<Integer, Integer>> stack , int count){
            this.stack = stack;
            this.count = count;
            this.result = new ArrayList<>();
        }
        // TODO: You can add your custom initialisation logic here.

        /**
         * Writes a single integer value using the appropriate encoding.
         */
        public void write(int value) {
            if(this.stack.size()==0){
                this.stack.add(new Pair(value, 1));
            }else {
                Pair<Integer, Integer> peek = this.stack.peek();
                if (value == peek.getKey()) {
                    this.stack.pop();
                    this.stack.push(new Pair(peek.getKey(), peek.getValue() + 1));
                } else {
                    this.stack.add(new Pair(value, 1));
                }
            }
            this.count=  this.count+1;
            Optional<Run> encoding  = getEncoding();
            if(encoding.isPresent()){
                this.result.add(encoding.get());
            }
        }
        public Optional<Run> getEncoding(){
            if(this.count>8 && stack.size()==2) {
                Pair<Integer, Integer> curr  =  this.stack.pop();
                this.stack.push(curr);
                count=1;
                return Optional.of(new RLE(stack.pop().getKey(), stack.pop().getValue()));
            } else if(this.count==8 && this.stack.size()>1){
                int [] arr = getArr(this.stack);
                count=0;
                return Optional.of(new BP(arr, 8));
            }else{
                return Optional.empty();
            }

        }

        public Optional<Run> getFinalEncoding(){
            if(stack.size()==1) {
                Pair<Integer, Integer> top = stack.pop();
                return Optional.of(new RLE(top.getKey(), top.getValue()));
            }
            else if(this.stack.size()>1){
                int [] arr = getArr(this.stack);
                return Optional.of(new BP(arr, 8));
            }
            return Optional.empty();
        }



        public static int [] getArr(Stack<Pair<Integer, Integer>>st) {
            int [] arr = new int [8];
            int indx =7;
            while(st.size()>0){
                Pair<Integer, Integer> curr  = st.pop();
                for(int i=0;i<curr.getValue();i++){
                    arr[indx] = curr.getKey();
                    indx--;
                }
            }
            return arr;
        }

        /**
         * Returns the encoded representation of the integer values that have been
         * accumulated so far.
         *
         * No `Encoder::write()` method will be invoked once this method was called.
         * The method should return data in the format understood by `Decoder`.
         */
        public ArrayList<Run> getData() {
            Optional<Run> finalEncoding  = getFinalEncoding();
            if(finalEncoding.isPresent()){
                this.result.add(finalEncoding.get());
            }
            return (ArrayList<Run>) this.result;
        }
    }

    public static class Decoder {

        public Decoder() {
            // TODO: You can add your custom initialisation logic here.
        }

        /**
         * Sets the data provided by `Encoder`, output of `Encoder::getData()`.
         * This method is only called once to initialise the `Decoder` instance.
         */
        public void setData(ArrayList<Run> data) {
            // TODO
        }

        /**
         * Returns true if there is at least one more value to read from the
         * decoder, false otherwise.
         *
         * This method is used in combination with `Decoder::next()`.
         *
         * Example:
         *   if (decoder.hasNext()) {
         *     decoder.next();
         *   }
         */
        public boolean hasNext() {
            return false; // TODO
        }

        /**
         * Decodes and returns an integer value.
         * An error is thrown/returned if there are no more values to decode.
         */
        public int next() {
            return 0; // TODO
        }
    }

    public static void main(String[] args) {
//         Example of how to use the encoder:
        Stack<Pair<Integer, Integer>> st = new Stack<>();
         Encoder encoder = new Encoder(st, 0);
         encoder.write(1);
         encoder.write(2);
         encoder.write(2);
        encoder.write(2);
        encoder.write(2);
        encoder.write(2);
        encoder.write(2);
        encoder.write(2);
        encoder.write(2);
        encoder.write(2);
        encoder.write(2);
        encoder.write(1);
         System.out.println(encoder.getData());

        // Example of how to use the decoder:
        //
        // Decoder decoder = new Decoder();
        // decoder.setData(encoder.getData());
        //
        // while (decoder.hasNext()) {
        //   System.out.println(decoder.next());
        // }
    }
}
