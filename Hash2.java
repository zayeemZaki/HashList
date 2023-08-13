/*Hash2 class which is very similar to Hash1 except the way hash is determined,
 * in this we take the hash of first character only */

public class Hash2 extends BaseList{
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
	//HashOFString method which takes the ASCII of first character of the word
	public int HashOfString(String s){
		//returns reminder of ASCII number of first character when divided by 255
		return s.charAt(0) & 255;
	}
}
