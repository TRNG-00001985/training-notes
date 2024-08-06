package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionsDemo {
	
	public static void main(String[] args) {
		
		List<Integer> arrayList = new ArrayList();
		
		arrayList.add(1);
		arrayList.add(0,2);
		arrayList.set(1, 3);
		arrayList.remove(0);
		arrayList.get(0);
		
		Iterator<Integer> i = arrayList.iterator(); 
		
		while(i.hasNext()) {
			System.out.println(i.next());
			
		}
		
		
		
		// size = n
		// size = n+n/2+1
		
		List<String> vectorObj = new Vector<String>();
		
		vectorObj.add("demo1");
		vectorObj.remove(0);
		
		Stack<Integer> stackObj = new Stack();
		
		stackObj.push(1);
		stackObj.push(2);		
		stackObj.pop();
		
		System.out.println(stackObj.peek());
		
		ArrayDeque <Integer> ad = new ArrayDeque();
		

		ad.offerFirst(3);
		ad.offerLast(4);
		ad.offerLast(4);
		ad.pollFirst();
		ad.pollLast();
		ad.element();
		
		Queue<Integer> pq = new PriorityQueue();
		
		pq.offer(1);
		pq.offer(3);
		pq.offer(-10);
		
		for(Integer j: pq) {
			System.out.println(j);
		}
		
		LinkedList<String> ll = new LinkedList();
		
		ll.add("adsa");
		ll.offer("ssf");
		
		HashSet <Integer> hs = new HashSet();
		hs.add(4);
		System.out.println(hs.contains(4));
		
		TreeSet<Integer> ts = new TreeSet();
		
		ts.add(3);
		ts.add(6);
		ts.add(0);
		ts.add(5);
		
		for(Integer j: ts) {
			System.out.println(j);
		}
		
		System.out.println("TS ceiling: "+ ts.ceiling(5));
		
		int[] arr = {0,4,5,6,0,2,4};
		
		HashMap <Integer, Integer> hm = new HashMap();
		
		for(int k:arr) {
			if(hm.containsKey(k)) {
				hm.put(k, hm.get(k)+1);
			}
			else {
				hm.put(k, 1);
			}
		}
		
		hm.put(null, null);
		
		for(Map.Entry<Integer, Integer> m: hm.entrySet() ) {
			System.out.println("Key:"+ m.getKey() +" No of occurances: "+ m.getValue());
		}
		
		System.out.println(hm.get(0).hashCode());
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		players.add(new Player(5,"Travis", 1,32));
		players.add(new Player(3,"Travis", 1,32));
		players.add(new Player(1, "Patrik", 5, 27));
		players.add(new Player(4,"Travis", 1,32));
		
		PlayerComparator pc = new PlayerComparator();
		
		Collections.sort(players,pc);
		Collections.reverse(arrayList);
		Collections.min(arrayList);
		
		for(Player p : players) {
			System.out.println(p.toString());
		}
		
		String s1 = "cat";
		String s2 = "cat";
		
		System.out.println(s1.compareTo(s2));
		
	}

}
