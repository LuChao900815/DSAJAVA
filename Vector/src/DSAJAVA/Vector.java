package DSAJAVA;
import java.lang.reflect.Array;

/**
 * Vector
 * @author LC
 *
 */
public class Vector <T> {
	private Object[] elementObject;
	private int size;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	
	
	public Vector(int initCapacity){
		if(initCapacity < 0){
			throw new IllegalArgumentException("Illegal Capacity: " + 
					initCapacity);
		}
		
		this.elementObject = new Object[initCapacity];
		this.size = 0;
	}
	
	public Vector(){
		this(10);
	}
	
	//set
	public T set(int index, T elem){
		rangeCheck(index);
		
		@SuppressWarnings("unchecked")
		T oldValue = (T)elementObject[index];
		elementObject[index] = elem;
		return oldValue;
	}
	
	//get 
	public T get(int index){
		rangeCheck(index);
		return (T)elementObject[index];
	}
	
	//judge the vector is empty
	boolean isEmpty(){
		return size == 0;
	}
	
	//find the element in array, if not return -1
	public  int indexOf(Object obj){
		if(obj == null){
			for(int i = 0; i < size; ++i){
				if(elementObject[i] == null){
					return i;
				}
			}
		}else{
			for(int i = 0; i < size; ++i){
				if(obj.equals(elementObject[i])){
					return i;
				}
			}
		}
		return -1;
	}
	
	public int lastIndexOf(Object obj){
		if(obj == null){
			for(int i = size - 1; i > -1; --i){
				if(elementObject[i] == null){
					return i;
				}
			}
		}else{
			for(int i = size - 1; i > -1; --i){
				if(obj.equals(elementObject[i])){
					return i;
				}
			}
		}
		return -1;
	}
	
	//to judge the array contains object
	public boolean contains(Object obj){
		return indexOf(obj) > 0;
	}
	
	
	
	//ensure the capacity to be minCapacity
	//if the minCapacity is too huge,throw a exception
	private void ensureCapacity(int minCapacity)
	{
		int oldCapacity = elementObject.length;
		
		oldCapacity = oldCapacity + (oldCapacity >> 1); //1.5 times
		
		minCapacity = Math.max(minCapacity, oldCapacity);
		
		if(minCapacity > MAX_ARRAY_SIZE){
			throw new OutOfMemoryError("miniCapacity is too large");
		}
		
		elementObject = copyOf(elementObject,minCapacity);
	}
	
	//check index is in range
	private void rangeCheck(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}
	}
	
	//constructs an IndexOutOfBoundsException detail message.
	private String outOfBoundsMsg(int index){
		return "Index: " + index + ", Size: " + size;
	}
	
	//copy from the old array to a new array which its size 
	//is newSize
	@SuppressWarnings("unchecked")
	private T[] copyOf(Object[] elementObject2,int newSize)
	{
		return (T[]) copyOf(elementObject2,newSize,elementObject2.getClass());
	}
	
	@SuppressWarnings("unchecked")
	private <T,U> T[] copyOf(U[] original,int newsize,Class<? extends T[]> newType){
		T[] copy = ((Object)newType == (Object)Object[].class)
	            ? (T[]) new Object[newsize]
	            : (T[]) Array.newInstance(newType.getComponentType(), newsize);
	    for(int i = 0; i < Math.min(original.length, newsize); ++i){
	    	copy[i] = (T) original[i];
	    }
	    return copy;
	}
	
	public boolean add(T e){
		ensureCapacity(size+1);
		elementObject[size++] = e;
		return true;
	}
	
	//add 
	public boolean add(int index,T e){
		rangeCheckForAdd(index);
		ensureCapacity(size+1);
		for(int i = size; i > index; --i){
			elementObject[i] = elementObject[i-1];
		}
		elementObject[index] = e;
		return true;
	}
	
	
	//range check for add because index can equal to size
	private void rangeCheckForAdd(int index){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}
	}
	
	//remove
	public  T remove(int index){
		rangeCheck(index);
		T oldValue = (T)elementObject[index];
		removeRange(index,index+1);
		elementObject[--size] = null; //clear to let GC works
		return oldValue;
	}
	
	//removeRange,[fromIndex,toIndex)
	public void removeRange(int fromIndex,int toIndex){
		rangeCheck(fromIndex);
		rangeCheck(toIndex);
		if(fromIndex >= toIndex)
			return;
		while(toIndex < size){
			elementObject[fromIndex++] = elementObject[toIndex++]; 
		}
		for(int i = fromIndex; i < size; ++i){
			elementObject[i] = null; // let GC works
		}
		size = fromIndex;
	}
	
	//clear 
	void clear(){
		for (int i = 0; i < size; i++){
            elementObject[i] = null;
		}
        size = 0;
	}
}
