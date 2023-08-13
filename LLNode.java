//----------------------------------------------------------------------------
// LLNode.java               
//
// Implements <T> nodes for a Linked List.
//----------------------------------------------------------------------------


public class LLNode{
	
	protected String info;
	protected int count;
	protected LLNode link;
	
	public LLNode(String info)
	{
		this.info = info;
		count = 1;
	}
	
	public void setCount(int count)
	{
		this.count = count;
	}
	public void setLink(LLNode link)
	{
		this.link = link;
	}
	
	
	public int getCount()
	{
		return count;
	}
	public String getInfo()
	{
		return info;
	}
	public LLNode getLink()
	{
		return link;
	}
}
