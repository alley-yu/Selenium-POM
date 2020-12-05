package JavaCollectionFramework;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashMapInitialization {
	
	public static Map<String, String> marksMap; //Create a static map varible
	
	//Initialize it in a static block
	static {
		marksMap = new HashMap<>();
		marksMap.put("A", "StaticMap value 1");
		marksMap.put("B", "StaticMap value 2");
	}
	
	public static void main(String[] args) {
		
		//1. HashMap class
		HashMap<String, String> map1 = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		
		//2. Static way: Static HashMap
		System.out.println(HashMapInitialization.marksMap.get("A"));
		
		//3. Immutable map with only one single entry, mapping only the specified key to the specified value 
		Map<String, String> singletonMap = Collections.singletonMap("C", "Singleton Value 1");
		System.out.println(singletonMap.get("C"));
		//singletonMap.put("D", "test"); will get error "UnsupportedOperationException" becuase of singleton
		
		//4. JDK 8: Create one 2D array of Strings using Stream and collecting it into the form of map
		Map<String, String> jdk8Map = (Map<String, String>) Stream.of(new String [][] {
			{"Alley", "A Grade"},
			{"Jon", "A+ Grade"},
		}).collect(Collectors.toMap(data -> data[0], data -> data[1]));
		
		System.out.println(jdk8Map.get("Alley"));
		jdk8Map.put("Yufei", "A++ Grade");
		System.out.println(jdk8Map.get("Yufei"));
		
		//5. SimpleEmtry -> mutable map
		Map<String, String> simpleEntryMutableMap = Stream.of(
				new AbstractMap.SimpleEntry<>("Alley", "Java"),
				new AbstractMap.SimpleEntry<>("Yufei", "Python")
				).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		System.out.println(simpleEntryMutableMap.get("Alley"));
		simpleEntryMutableMap.put("Owen", "Baby Language");
		System.out.println(simpleEntryMutableMap.get("Owen"));
		
		//6. SimpleEmtry -> immutable map
		Map<String, String> simpleEntryImmutableMap = Stream.of(
				new AbstractMap.SimpleImmutableEntry<>("Alley", "Java"),
				new AbstractMap.SimpleImmutableEntry<>("Yufei", "Python")
				).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
				
		System.out.println(simpleEntryImmutableMap.get("Alley"));
		simpleEntryImmutableMap.put("Owen", "Baby Language");
		System.out.println(simpleEntryImmutableMap.get("Owen"));
				
		//7. JDK 1.9
		//Empty Map, empty map cannot be initialized
		Map<String, String> emptyMap = Map.of();
		//emptyMap.put("A", "Test");//Error: UnsupportedOperationException
		

		//Singleton map
		Map<String, String> singletonMap1 = Map.of("K1", "SingletonMapValue1");
		System.out.println(singletonMap1.get("K1"));
		//singletonMap1.put("K2", "Test"); //Error: UnsupportedOperationException because of singleton map
		
		//Muti values map: only allow max 10 key-value pairs
		Map<String, String> multiValueMap = Map.of("K1", "V1", "K2", "V2", "K3", "V3"); 
		System.out.println(multiValueMap.get("K2"));
		
		//ofEntry method: no limitation on key-value pairs: Immutable Map
		Map<String, Integer> multiValueMap1 = Map.ofEntries(
				new AbstractMap.SimpleEntry<>("A", 100),
				new AbstractMap.SimpleEntry<>("B", 200),
				new AbstractMap.SimpleEntry<>("C", 300)
				);
		System.out.println(multiValueMap1.get("B"));
		
	}

}
