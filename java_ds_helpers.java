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

// converting ArrayList to an arrray
Integer temp[] = new Integer[object.size()];
object.toArray(temp); // temp array has the contents of object


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

---------------------------HashTable--------------------------------------------------

HashMap<String, Integer> map = new HashMap<>();
map.put("Abhi", 12);
if(map.containsKey("Abhi")){
Integer value = map.get("Abhi");
map.put(key, map.get(key) + 1); // general method to update the table
}
map.values(); // gives a list of all the values

