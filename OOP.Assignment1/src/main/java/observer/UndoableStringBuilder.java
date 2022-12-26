package observer;
import java.util.Stack;
/*
Use the class you've implemented in previous assignment
 */
public class UndoableStringBuilder {

        private StringBuilder str;
        private Stack<String> stk;

        UndoableStringBuilder(){
            str=new StringBuilder();
            stk=new Stack<String>();
        }

        /**
         * Appends the specified string to this character sequence.
         * @param str string
         * @return given string is appended to the right of this char sequence.
         */
        public StringBuilder append(String str){
            stk.push(this.str.toString());
            this.str.append(str);
            return this.str;
        }

        /**
         * Removes the characters in a substring of this sequence. The substring begins
         * at the specified start and extends to the character at index
         * end - 1 or to the end of the sequence if no such character exists.
         * If start is equal to end, no changes are made.
         * @param start int
         * @param end int
         * @return a string without the deleted substring.
         */

        public StringBuilder delete(int start, int end) {
            try {
                stk.push(str.toString());
                str.delete(start, end);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Wrong index has been entered!! pls try again");
                System.err.println(e);
                stk.pop();
            }
            return str;
        }

        /**
         * Inserts the string into this character sequence.
         * @param offset start index that the string is inserted
         * @param str the inserted string
         * @return a string that contains the given substring.
         */
        public StringBuilder insert(int offset, String str){
            try {
                stk.push(this.str.toString());
                this.str.insert(offset, str);
            }catch (StringIndexOutOfBoundsException e) {
                System.out.println("Wrong index has been entered!! pls try again");
                System.err.println(e);
                stk.pop();
            }
            return this.str;
        }

        /**
         * Replaces the characters in a substring of this sequence with characters in
         * the specified String. The substring begins at the specified start and
         * extends to the character at index end - 1 or to the end of the sequence if
         * no such character exists. First the characters in the substring are removed
         * and then the specified String is inserted at start. (This sequence will be
         * lengthened to accommodate the specified String if necessary).
         * @param start int start
         * @param end int end
         * @param str new string
         * @return a string after the remove and insertion of the given substring.
         */

        public StringBuilder replace(int start,int end, String str){
            try {
                stk.push(this.str.toString());
                this.str.replace(start, end, str);
            }catch (StringIndexOutOfBoundsException e){
                System.out.println("Wrong index has been entered!! pls try again");
                System.err.println(e);
                stk.pop();
            }
            return this.str;
        }

        /**
         * Causes this character sequence to be replaced by the reverse of the
         * sequence.
         * @return the String reversed
         */

        public StringBuilder reverse(){
            stk.push(str.toString());
            str.reverse();
            return str;
        }


        /**
         * changes the string to its previous condition.
         * if the string is empty then nothing happens.
         */
        public void undo(){
            if(!stk.isEmpty()){
                StringBuilder temp = new StringBuilder();
                temp.append(stk.pop());
                str = new StringBuilder(temp.toString());
            }
        }
        /**
         * print method
         */
        @Override
        public String toString() {
            return ""+str+"";
        }
    }



