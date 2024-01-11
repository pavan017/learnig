###Questions

We are going to design a cache library with the following features:
- It should be able to support key and values of any type.
- It should support operations such a get, remove, put (10-15 mins)
- We should not care about the size of the cache / eviction policies right now, but our design should be extensible.
- It should be thread safe and efficient (5-10 mins)
- It should have implementations for better accessing and processing of complex structures like set / map as values (10-20 mins)
- It should be thread-safe even when considering the complex structures (5-10 mins)
- (Optional) How do we make this cache distributed. (5-10 mins)



 







Interface Store<K,V> {


	V get(K key) {
		}

	V put(K key, V value) {
			}

	V remove(K key) {
			}
}

Class cache<K,V> {
Map<K, Store> storeMap;

if(k.isTypeOf(Integer)){

}



}

cache = new Cache<Integer, String>


Class IntegerStore<V> {
Map<Integer, V> intMap =new HashMap<>()
V get(K key) {
return this.map.get(key);
}

	V put(K key, V value) {
		syncronise(this){
			Pair<V, DateTime> obj =  new Pair(value, currewntTimeStamp+)
			this.map.put(key, value);
}
}

	V remove(K key) {
		syncronise(this){
			this.map.remove(key);
}
}

}

Class StringStore<V>{
Map<Integer, V> intMap =new HashMap<>()
}

	









