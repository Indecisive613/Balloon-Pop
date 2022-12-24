import processing.core.*;
 
public class Sketch extends PApplet {
 static PApplet pa;
 
 Balloon[] balloon = new Balloon[10];
 
 /**
 * Method settings
 * Pre: none
 * Post: Sets size of screen
 *
 * @param none
 */
 public void settings() {
   pa = this;
   size(400, 400);
   smooth();
 }
 
 /**
 * Method setup
 * Pre: none
 * Post: Creates balloon objects
 *
 * @param none
 */
 public void setup() {
   for (int i = 0; i < 10; i++){
     balloon[i] = new Balloon();
   }
 }
 
 /**
 * Method draw
 * Pre: none
 * Post: Runs and updates screen outputs
 *
 * @param none
 */
 public void draw() {
   pa.background(0);
 
   for (int i = 0; i < 10; i++){
     balloon[i].display();
   }
   for (int i = 0; i < 10; i++){
     balloon[i].move();
   }
 }
  /**
 * Method mouseClicked
 * Pre: none
 * Post: Check if mouse click is within balloon; if true, it pops (disappears) and a new one is generated
 *
 * @param none
 */
 public void mouseClicked(){
   for (int i = 0; i < 10; i++){
     if (balloon[i].popped(mouseX, mouseY)){
       balloon[i] = new Balloon();
     }
   }
 }
}
