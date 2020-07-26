package lesson01.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class LearnSet {

	@Test
	public void test01() {
		int n;
		ArrayList<String> list = new ArrayList<String>();
		HashSet<Object> hashSet = new HashSet<Object>();
		HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
		hashMap.put(null, 1);
		System.out.println(hashMap);
		LinkedHashMap<Object, Object> map = new LinkedHashMap<Object, Object>();
		map.put(null, null);
		System.out.println(map);
		Collections.synchronizedMap(hashMap);
		String a = "qw";
		int hashCode = a.hashCode();System.out.println(hashCode);
		int hash = Objects.hashCode(a);System.out.println(hash);
		Integer aInteger= 1;
	}
	
	@Test
	public void test02() {
		ArrayList<Integer> list = new ArrayList<Integer>(5);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list.size());
		int[] a = new int[] {};
		System.out.println(a.length);
//		a[0] = 1;
//		System.out.println(a[0]);
		String b[] = new String[] {"1","2","5"};
		System.out.println(b[4]);
	}
}
