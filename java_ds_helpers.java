-----------Input----------------------------
1. Take input of array when size is not mentioned
----Take array as a string
List<Integer> list = new ArrayList<>();
String s = scanner.nextLine();
String str[] = s.split("\\s");
for(String i: str){
	list.add(Integer.parseInt(i));
}

2. Take input of array when comma/space/comma with space separated stream of numbers is given
Scanner sc = new Scanner(System.in);
int n = Integer.parseInt(sc.nextLine());
String inp = sc.nextLine();
String arr[] = inp.split(" ");
int temp;
for(String c: arr) {
    temp = c.trim().charAt(0) - '0';
    System.out.print(temp);
}
// i/p: 3
//      1,2,3
// o/p  123
// i/p: 3
//      1 2 3
// o/p  123
// i/p: 3
//      1, 2, 3
// o/p  123

3. take input of array when comma/space/comma with space separated stream of characters is given
Scanner sc = new Scanner(System.in);
int n = Integer.parseInt(sc.nextLine());
String inp = sc.nextLine();
String arr[] = inp.split(" ");
int temp;
for(String c: arr) {
    temp = c.trim().charAt(0);
    System.out.print(temp);
}
// i/p: 3
//      a, b, c
// o/p  abc

//Sort array
Arrays.sort(array);   
-------------String---------------

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
str.contains("air");  // returns true

// to convert any data type into string
int value = 30;  
String s1 = String.valueOf(value); // String.valueOf() converts anything into string 
System.out.println(s1+10);//concatenating string with 10  outputs is: 3010


// converting string value to number for operations
int sum=0;
int sum2=0;
String n = "1234";
for(int i=0;i<n.length();i++){
    sum += Character.getNumericValue(n.charAt(i)); // method 1
    sum2 += n.charAt(i) - '0'; // method 2
}


-------------------StringBuilder---------------------------

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

StringBuilder str = new StringBuilder("GeeksForGeeks"); 
str.indexOf("For"); // returns 5 and -1 when not present
str.length();
str.capacity(); // returns 16 + 13 = 29
str.charAt(3); // returns 'k'
str.setCharAt(3, 'l'); // k ban gaya l and returns nothing
str.deleteCharAt(6); 

---------------------ArrayList------------------------------
// to sort list use Collections-
Collections.sort(list)
	
ArrayList<Integer> object = new ArrayList<Integer>(n);
List<Integer> object_new = new LinkedList<Integer>():
object.add(5); // appends 5
object.remove(i); //removes element present at ith index
object.addAll(object_new); // elements from object_new will get appended 
object.removeAll(object_new); //removes elements from object which are present in object_new
object.set(3, 85);  //sets value 85 at 3rd index
object.get(i); //similar to arr[i]
boolean status = object.contains(2);
boolean full = !(object.isEmpty(object)); // using not operatorin java
object.size();
// Iterating in ArrayList
for(Integer i: object) {
	System.out.print(i);
};

Iterator it = object.iterator();
while (it.hasNext())
         System.out.print(it.next() + " ");

object.forEach(number->System.out.println(number));

// use this to remove in arraylist instead of using ArrayList.remove()
Iterator itr = object.iterator();
while (itr.hasNext())
{
    int x = (Integer)itr.next();
    if (x < 10)  // if condition
	itr.remove();
}

// converting ArrayList to an arrray
Integer temp[] = new Integer[object.size()];
object.toArray(temp); // temp array has the contents of object

// always take care of this base case
if(object.size()==0 || object==null)
	
--------------------------LinkedList------------------------------------------
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

------------------------Stack/Queue--------------------------------------------

Stack<Integer> stack = new Stack<Integer>();
stack.push(5);
Integer poppeditem = (Integer)stack.pop();
Integer topitem = (Integer)stack.peek();
Integer position = (Integer)stack.search(5);
boolean status = stack.empty();

Queue<Integer> queue = new LinkedList<Integer>();
for(int i=0; i<5; i++){
queue.add(i);
} // adds [0, 1, 2, 3, 4]
Integer head = queue.remove();  // returns 0

Deque-
The Deque supports the addition as well as the removal of elements from both ends of the data structure. Therefore, a deque can be used as a stack or a queue.
	
 //Creating Deque and adding elements  
   Deque<String> deque = new ArrayDeque<String>();  
   deque.add("Ravi");    
   deque.add("Vijay");     
   deque.add("Ajay");    
   //Traversing elements  
   for (String str : deque) {  
   System.out.println(str);  
  }   

---------------------------HashTable--------------------------------------------------

HashMap<String, Integer> map = new HashMap<>();
map.put("Abhi", 12);
if(map.containsKey("Abhi")){
Integer value = map.get("Abhi");
map.put(key, map.get(key) + 1); // general method to update the table
}
map.values(); // gives a list of all the values

--- To iterate in hashmap we use entrySet()
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

-------------------------- Depth First Search --------------------------------------

// on graph
void dfs(int currNode){
    visited[currNode] = 1;
    
    for(int adjNode : adj[currNode]){
        if(visited[adjNode]==0){
            dfs(adjNode);
        }
    }
}

// on 2D grid
// cell  = node
// sides = edges
// sides + corners = edges
