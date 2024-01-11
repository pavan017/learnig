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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DataBricks_2_orignal {

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
        int[] data = new int[8]; // integer values for Bit-Packing encoding
        int count = 0; // length of the `data` array, at most 8 values

        @Override
        public String toString() {
            return "BP(" + Arrays.toString(Arrays.copyOf(data, count)) + ")";
        }
    }

    // API classes and methods to implement

    public static class Encoder {
        // 1 10 , 2 , 3

        Stack<List<Integer>> stack  = new Stack<>();
        int count;
        public Encoder(Stack<List<Integer>> stack , int count){
            this.stack = stack;
            this.count = count;
        }
        // TODO: You can add your custom initialisation logic here.

        /**
         * Writes a single integer value using the appropriate encoding.
         */
        public void write(int value) {
            // [1, 1, 1, 1, 2, 3, 4, 5]
            // encoder.write(1); -> getData() -> RLE[1, 1]
            // encoder.write(1);
            // encoder.write(1);
            // encoder.write(1);
            // encoder.write(2);
            // encoder.write(3);
            // encoder.write(4);
            // encoder.write(5);
            List<Integer> peek = this.stack.peek();
            if(value == peek.get(0)){
                this.stack.pop();
                List<Integer> tmpLst = new ArrayList<>();
                tmpLst.add(peek.get(0));
                tmpLst.add(peek.get(1)+1);
                this.stack.push(tmpLst);
            }else{

            }
            this.count++;

            // List<Run> runs = encoder.getData();

            // TODO
        }

        /**
         * Returns the encoded representation of the integer values that have been
         * accumulated so far.
         *
         * No `Encoder::write()` method will be invoked once this method was called.
         * The method should return data in the format understood by `Decoder`.
         */
        public ArrayList<Run> getData() {

            List<Run> result = new ArrayList<>();


            return null; // TODO
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
        // Example of how to use the encoder:
        //
        // Encoder encoder = new Encoder();
        // encoder.write(1);
        // encoder.write(2);
        // ...
        // encoder.write(238);
        // System.out.println(encoder.getData());

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