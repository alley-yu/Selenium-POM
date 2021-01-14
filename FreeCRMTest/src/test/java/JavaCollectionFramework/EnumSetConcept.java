package JavaCollectionFramework;

import java.util.EnumSet;
import java.util.Iterator;

public class EnumSetConcept {
	
	//Enum: A Java Enum is a special Java type used to define collections of constants, a special Java class.
	
	enum Language {
		JAVA, PYTHON, JAVASCRIPT, RUBY
	}

	public static void main(String[] args) {
		
		//create a enumset
		EnumSet<Language> langs = EnumSet.allOf(Language.class);
		System.out.println(langs);
		
		//empty enum set
		EnumSet<Language> emptyEnumSet = EnumSet.noneOf(Language.class);
		System.out.println(emptyEnumSet);
		
		//range(e1, e2)
		EnumSet<Language> subEnumSet = EnumSet.range(Language.PYTHON, Language.JAVASCRIPT);
		System.out.println(subEnumSet);
		
		//of
		EnumSet<Language> certainEnum = EnumSet.of(Language.JAVASCRIPT);
		System.out.println(certainEnum);
		
		EnumSet<Language> multiEnum = EnumSet.of(Language.JAVA, Language.RUBY);
		System.out.println(multiEnum);
		
		//add and addAll()
		EnumSet<Language> lang1 = EnumSet.allOf(Language.class);
		EnumSet<Language> lang2 = EnumSet.noneOf(Language.class);
		lang2.add(Language.JAVASCRIPT);
		System.out.println(lang2);
		lang2.addAll(lang1);
		System.out.println(lang2);
		
		//Iterator
		Iterator<Language> it = lang2.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		//remove and removeAll();
		boolean remove = lang2.remove(Language.RUBY);
		System.out.println("Language.Ruby is removed: " + remove);
		System.out.println(lang2);

	}

}
