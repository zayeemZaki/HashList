// BaseList.java
//
// This class is just a starting point for the 2 lists that will be used in this project.
// Because the only thing that will differentiate them is the WAY we do the additions to the
// list, we can put all of the code that's common to ALL of them here, and use inheritance
// to build the four specific lists. We declare this one as being abstract simply to keep
// from accidentally instantiating it -- it doesn't HAVE its add method.
//
// By forcing this layer of inheritance into the process, every list's class just consists
// of a one-line constructor (to call this one), and its add() method.

public abstract class BaseList implements ListInterface{
	
	 LLNode list[];
	 private int numOfLists = 256;
	 int minNode, maxNode;
	 float stdDeviation;
	 long refChanges;
	 long keyCompare;
	 
	public BaseList(){
		
		list = new LLNode[numOfLists];
		refChanges = 0;
		keyCompare = 0;
	}
	
	public LLNode getList(int index){
		
		 return list[index];
	}
	
	@Override
	public long getRefChanges(){
		 // How many reference changes did we do (how much structural work)?
		 //
		 return refChanges;
	}
	
	@Override
	public long getKeyCompare(){
		 // How many key comparisons (how much work was done looking for things on the list)?
		 //
		 return keyCompare;
	}

	@Override
	public int getDistinctWords(){
		
		int count = 0; 
		int i = 0;	
		
		while(i < list.length){
			
			LLNode currNode = list[i++];
			
			while(currNode != null){
				count++;
				currNode = currNode.getLink();
			}
		}
		return count;
	}
	
	@Override
	public int getTotalWords(){

		int count = 0; 
		int i = 0;	
		
		while(i < list.length){
			LLNode currNode = list[i++];
			while(currNode != null){
				count += currNode.getCount();
				currNode = currNode.getLink();
			}
		 }
		 return count;
	}
	
}