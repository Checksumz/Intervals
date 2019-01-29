package main.java;


import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
	
	private int numberOfIntervals ; 
	
	public static class Interval{
		private int floorOfInterval;
		private int ceilingOfInterval;
		
		public Interval(int floorOfInterval, int ceilingOfInterval) {
			this.floorOfInterval = floorOfInterval ;
			this.ceilingOfInterval = ceilingOfInterval;			
		}
		

		public StringBuilder toStringBuilder() {
			return  (new StringBuilder().append(this.floorOfInterval).append(", ").append(ceilingOfInterval));			
		}
		
		public String toString() {
			return  new String(floorOfInterval+", "+ceilingOfInterval);			
		}
	}
	
	public void intervals() {
		System.out.println("enter number of intervals");
		try(Scanner in = new Scanner(System.in)){
			int numberOfIntervals=in.nextInt();
			

			List<Interval> al = new ArrayList<Interval>();
			
			in.useDelimiter("\r\n|\\,");
			for(int i=0; i<numberOfIntervals; i++) {
				System.out.println("enter floor,ceiling of interval");
				al.add(new Interval(in.nextInt(), in.nextInt()));				
			}
			
			System.out.println(al.stream().map(Interval::toStringBuilder).collect(Collectors.joining("\r\n")));
			
			al.sort(Comparator.comparingInt(o -> o.floorOfInterval));
			
			System.out.println(al.stream().map(Interval::toStringBuilder).collect(Collectors.joining("\r\n")));
			
//			ListIterator<Interval> it = al.listIterator(1);
			
			
//			while(it.hasNext()) {
//				System.out.println("it.previousIndex() "+it.previousIndex());
//				System.out.println("it.nextIndex() "+it.nextIndex());
//				if(it.previous().ceilingOfInterval >= it.next().floorOfInterval) {
//					System.out.println("it.previousIndex() "+it.previousIndex());
//					System.out.println("it.nextIndex() "+it.nextIndex());
//					System.out.println("it.previous().floorOfInterval "+it.previous().floorOfInterval);
//					System.out.println("it.next().ceilingOfInterval "+it.next().ceilingOfInterval);
//					System.out.println("it.next().ceilingOfInterval "+it.next().ceilingOfInterval);
//					System.out.println("it.previousIndex() "+it.previousIndex());
//					System.out.println("it.nextIndex() "+it.nextIndex());
//					it.set(new Interval(it.previous().floorOfInterval, it.next().ceilingOfInterval));
//					System.out.println("it.previousIndex() "+it.previousIndex());
//					System.out.println("it.nextIndex() "+it.nextIndex());
//					System.out.println(al.toString());
//					it.previous();
//					it.remove();
//					System.out.println("it.previousIndex() "+it.previousIndex());
//					System.out.println("it.nextIndex() "+it.nextIndex());
//					System.out.println(al.toString());
//				}
//			}
//			
			
			
			for(int i=0; i<al.size()-1;i++) {
				
				System.out.println(i+" "+al.get(i).toStringBuilder());
				System.out.println(i+" "+al.toString());
				if(al.get(i).ceilingOfInterval>=al.get(i+1).floorOfInterval) {
					al.add((i),new Interval(al.get(i).floorOfInterval, al.get(i+1).ceilingOfInterval));
					al.remove(i+1);
					al.remove(i+1);			
					i--;
				}
				
				System.out.println(i+" "+al.toString());
				
			}
			
			System.out.println(al.stream().map(Interval::toStringBuilder).collect(Collectors.joining("\r\n")));
		}
		

	}

	public static void main(String[] args) {

		Main m=new Main();
		m.intervals();
		
		
	}

}
