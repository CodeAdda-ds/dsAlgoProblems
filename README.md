#### `Arrays`
##### Input
Take input of array when size is not mentioned
```java
// take array as a string
List<Integer> list = new ArrayList<>();
String s = scanner.nextLine();
String str[] = s.split("\\s");
for(String i: str){
	list.add(Integer.parseInt(i));
}
```
Take input of array when comma/space/comma with space separated stream of numbers is given
```java
// i/p: 3
//      1,2,3
// o/p  123
// i/p: 3
//      1 2 3
// o/p  123
// i/p: 3
//      1, 2, 3
// o/p  123
Scanner sc = new Scanner(System.in);
int n = Integer.parseInt(sc.nextLine());
String inp = sc.nextLine();
String arr[] = inp.split(" ");
int temp;
for(String c: arr) {
    temp = c.trim().charAt(0) - '0';
    System.out.print(temp);
}
```

Take input of array when comma/space/comma with space separated stream of characters is given
```java
// i/p: 3
//      a, b, c
// o/p  abc
Scanner sc = new Scanner(System.in);
int n = Integer.parseInt(sc.nextLine());
String inp = sc.nextLine();
String arr[] = inp.split(" ");
int temp;
for(String c: arr) {
    temp = c.trim().charAt(0);
    System.out.print(temp);
}
```
##### Sorting
```java
// sorts the original array
Arrays.sort(array);
```
#### `String`

```java
String str = "airplane";
String s = " is flying";
str.charAt(2);  // returns 'r'
str.concat(s);  // str becomes "airplane is flying"
str += s;  // str becomes "airplane is flying"
str.length() // returns length
str.toLowerCase();
str.toUpperCase();
str.trim(); // removes the spaces before and after the string not in betweeen and returns a new string
char[] arr = str.toCharArray() // returns an array of characters
String newString = new String(arr); // creates a string from a character array
str.contains("air");  // returns true
if(str.equals("airplane")) // returns true

String a = "a1?"
Character.isLetterOrDigit(str.charAt(0))  // true
Character.isLetterOrDigit(str.charAt(1))  // true
Character.isLetterOrDigit(str.charAt(2))  // true
```
Convert any data type into string
```java
int value = 30;  
String s1 = String.valueOf(value); // String.valueOf() converts anything into string 
System.out.println(s1+10);//concatenating string with 10  outputs is: 3010
```
Converting string value to number for operations
```java
int sum=0;
int sum2=0;
String n = "1234";
int num = Integer.parseInt(n); // 1234
for(int i=0;i<n.length();i++){
    sum += Character.getNumericValue(n.charAt(i)); // method 1
    sum2 += n.charAt(i) - '0'; // method 2
}
```

Reversing a string and storing it somewhere
```java
String reverseString(String str){  
	char charArray[]=str.toCharArray();  
	int left = 0, right = charArray.length-1;
	while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }  
	String reversed = new String(charArray); // remember this to create a string from char array
	return reversed;  
}
// using StringBuilder
String reverseString(String str){  
        StringBuilder rev = new StringBuilder(str);
        rev.reverse();
        return rev.toString();
}
```
##### StringBuilder

```java
// we have this example using String CTCI pg 60
String joinWords(String[] words) {
    String sentence = "";
    for ( String w: words) {
        sentence += w;
    }
    return sentence;
}
// Its time complexity = O(x + 2x + 3x +... +nx) = O(xn^2)

// so we use StringBuilder
// StringBuilder creates a resizable array of all the strings, copying them back to a string only when necessary
String joinWords(String[] words) {
    StringBuilder sentence = new StringBuilder();
    for ( String w : words) {
        sentence.append(w);
    }
    return sentence.toString(); // again converted to String
}
```
```java
StringBuilder str = new StringBuilder("GeeksForGeeks"); 
str.indexOf("For"); // returns 5 and -1 when not present
str.length();
str.capacity(); // returns 16 + 13 = 29
str.charAt(3); // returns 'k'
str.setCharAt(3, 'l'); // k ban gaya l and returns nothing
str.deleteCharAt(6); 
```

#### `ArrayList`

```java
// to sort ArrayList/List use Collections-
Collections.sort(list);
	
ArrayList<Integer> object = new ArrayList<Integer>(n);
List<Integer> object_new = new LinkedList<Integer>():
object.add(5); // adds 5
object.remove(i); //removes element present at ith index
object.addAll(object_new); // elements from object_new will get appended 
object.removeAll(object_new); //removes elements from object which are present in object_new
object.set(3, 85);  //sets value 85 at 3rd index
object.get(i); //similar to arr[i]
boolean status = object.contains(2);
boolean full = !(object.isEmpty(object)); // using not operator in java
object.size(); // length
```
Iteration
```java
for(Integer i: object) {
	System.out.print(i);
};

// using iterator
Iterator it = object.iterator();
while (it.hasNext())
         System.out.print(it.next() + " ");

// using forEach
object.forEach(number->System.out.println(number));

// use this to remove from arraylist instead of using ArrayList.remove()
Iterator itr = object.iterator();
while (itr.hasNext())
{
    int x = (Integer)itr.next();
    if (x < 10)  
	itr.remove(); // x will be removed from the object
}
```
```java
// converting ArrayList to an arrray
Integer temp[] = new Integer[object.size()];
object.toArray(temp); // temp array has the contents of object
```
General Tips:
```java
// always take care of this base case
if(object.size()==0 || object==null)
```
#### `LinkedList`
```java
LinkedList<String> object = new LinkedList<String>();
object.add("A");
object.addFirst("B");
object.add(1, "C");
object.remove("B");
object.remove(2);
object.removeFirst();
object.removeLast();
boolean status = object.contains("D");
String element = object.get(1); //gets value at ith index
object.set(3, "Y");
object.size();
```
```java
// iterating the LinkedList
        for (int i = 0; i < object.size(); i++) {
            System.out.print(object.get(i) + " ");}

        int i = 0;
        while(i<object.size()){
            System.out.print(vowels.get(i) + " ");
            i++;}
            
        for (String listElement : object) {
            System.out.print(listElement + " ");}
            
        Iterator it = linkedList.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");}
	
	// to traverse in reverse
	ListIterator<String> lit = obj.listIterator(obj.size());
	while (lit.hasPrevious())
	    System.out.println(lit.previous());
            
        object.forEach(
            (element) -> System.out.print(element + " "));
```
#### `Stack/Queue`
```java
Stack<Integer> stack = new Stack<Integer>();
stack.push(5);
Integer poppeditem = (Integer)stack.pop(); // typecasting not required here but still added (aise hi)
int topitem = stack.peek(); // because of autoboxing, we don't need to explicitly typecast because java automatically converts Integer to int when necessary
Integer index = stack.search(5); // returns the index
boolean status = stack.empty(); // tells if the stack is empty or not
```
```java
Queue<Integer> queue = new LinkedList<Integer>();
for(int i=0; i<5; i++){
	queue.add(i);
} // adds [0, 1, 2, 3, 4]
Integer head = queue.remove();  // returns 0
```
##### Deque
The Deque supports the addition as well as the removal of elements from both ends of the data structure. Therefore, a deque can be used as a stack or a queue.
```java	
 //Creating Deque and adding elements  
   Deque<String> deque = new ArrayDeque<String>();  
   deque.add("Ravi");    
   deque.add("Vijay");     
   deque.add("Ajay");    
   //Traversing elements  
   for (String str : deque) {  
   System.out.println(str);  
   }   
```
##### Heap
Heap works like a Stack, the latest value inserted will be removed first

Time complexity: Nlog(K)

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<Integer> (); // used to find kth largest
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // used to find kth smallest

minHeap.offer(val); // push val into minHeap

// if size exceeds k, remove the latest element
if (minHeap.size() > k)
    minHeap.poll();

minheap.peek(); // returns the top of the minHeap

// iterate minHeap
while(!minHeap.isEmpty()) {
  // some work
}
```
#### `Map`
##### HashMap
```java
HashMap<String, Integer> map = new HashMap<>();
map.put("Abhi", 12);
boolean status = map.containsKey("Abhi");
Integer value = map.get("Abhi");
// ways to update the hashtable
map.put(key, map.get(key) + 1); 
map.put(key, mp.getOrDefault(key, 0) + 1); // here 0 is the default value if key doesn't exist

map.values(); // gives a list of all the values
```
Iteration
```java
// to iterate in hashmap we use entrySet()
Map<Integer, Integer> map = new HashMap<Integer, Integer>();
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
}

//Iterating over Keys only
for (Integer key : map.keySet()) {
    System.out.println("Key = " + key);
}

// Iterating over values only
for (Integer value : map.values()) {
    System.out.println("Value = " + value);
}

// to get Datatype type of key/value
map.forEach((k,v) -> System.out.println("Key type = "
                + k.getClass().getSimpleName() + ", Value type = " + v.getClass().getSimpleName() + ".")); // String aur Integer dega output me
```
Returning a sorted HashMap based on values
```java
// function to return a hashmap with sorted values
public static HashMap<String, Integer> createSortedHashMap(HashMap<String, Integer> inputMap) {
    // create an ArrayList of Map.Entry type so we can apply sort method on it 
    ArrayList<Map.Entry<String, Integer>> newList = new ArrayList<>(inputMap.entrySet());

    // Sort the list based on values
    Collections.sort(newList, new Comparator<Map.Entry<String, Integer>>() {
        @Override // method overloading
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
	    // Sorting in ascending order, for descending order, swap o1 and o2
	    return o1.getValue().compareTo(o2.getValue());
        }
    });

    // Create a LinkedHashMap to store sorted entries
    LinkedHashMap<String, Integer> sortedHashMap = new LinkedHashMap<>();
    for (Map.Entry<String, Integer> entry : newList) {
        sortedHashMap.put(entry.getKey(), entry.getValue());
    }
    return sortedHashMap;
}
```
##### Set
```java
HashSet<Integer> s = new HashSet<>();
s.add(3);
s.add(3);
s.add(4);
int len = s.size();
s.clear(); // to empty the set
boolean status = s.isEmpty();
boolean containsValue = s.contains(4); // true
boolean removedSuccessfully = s.remove(4); // remove element using value

// iterating
Iterator<Integer> itr = s.iterator();
while(itr.hasNext()) {
    int val = itr.next();
    if(val%2==0) {
        itr.remove(); // removes the element where the iterator is currently at
    }
    
}
```
##### TreeMap
```java
TreeMap<Integer, Integer> mp = new TreeMap<>();
// Creating a TreeMap that'll store the values in descending order
TreeMap<Integer, Integer> mp = new TreeMap<>(Collections.reverseOrder());
// creating a list of entries from the TreeMap 
List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(mp.entrySet());
// Sort the entries based on frequency (value) in descending order
entries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
// To get key of an entry at ith index
entries.get(i).getKey(); // you can get the value by using the getValue() method
```
