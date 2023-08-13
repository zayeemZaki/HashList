/*Hash1 is the class for the first function of hash in which we add
 * the hashes of each character and then the take reminder of hash when divided
 * by the 256 to get the index number, then we add the string in the list at that 
 * hash index using different methods depending if its already in the list 
 * at that index of the list or if we need to create new Node for it
 * 
 * We have one list with 256 nodes and then for each node we have created new list*/
public class Hash1 extends BaseList{
	//add method which adds the word at the index of the list(hash if string) 
	@Override
	public void add(String word){
		
		//calls HashOfString method to calculate the hash of the string
		int i = HashOfString(word);
		//first case when the list is null at the hash index
		if(list[i] == null)
			list[i] = new LLNode(word);//we create a new Node and add it as the first element
		//second case when the list at the hash index isn't null, in which we multiple sub cases
		else{
			LLNode currNode = list[i];//we create a variable currNode and set it to the first element
			
			keyCompare++;//increment comparisons
			//this case is used when the word to be added is the first element in the list 
			if(currNode.info.equals(word)){
				currNode.setCount(currNode.getCount()+1);//increment the count of the word in the list
				return;
			}
			//if the word isn't the first element of the list, we go to the next node in the list at hashed index 
			currNode = currNode.getLink();
			LLNode prevNode = list[i];//set prevNode variable to first element
			//while loop to traverse to the end of the list at Hashed Index
			while(currNode != null) {
				
				keyCompare++;//increment compare
				//if the word is found while traversing through the list
				if(currNode.info.equals(word)){
					
					currNode.setCount(currNode.getCount()+1);//increment the count of the word
					//prevNode link is set to the node which is after currNode, which disconnects currNode from the list
					prevNode.setLink(currNode.getLink());
					currNode.setLink(list[i]);//now currNode link is set to the first Node of the list
					list[i] = currNode;//and currNode is set as the first Node of the list
			
					return;
				}
				prevNode = currNode;//moves prevNode to next Node
				currNode = currNode.getLink();//moves currNode to nextNode
			}
			//when the word isn't found in the list at the hashed index of the list
			LLNode newNode = new LLNode(word);//new node is created to store the word
			newNode.setLink(list[i]);//newNodes link is set to first element 
			list[i] = newNode;//first element is set as newNode
		}
	}
	//hashOfString method which gets the hash of the word
	public int HashOfString(String s){
		
		int hash = 0;
		//for loop which adds the ASCII of each character 
		for(int i=0;i<s.length();i++){
			hash += s.charAt(i);
		}
		//returns the hash of the word by taking remainder of hash after divided by 255
		return hash % 255;
	}
}
