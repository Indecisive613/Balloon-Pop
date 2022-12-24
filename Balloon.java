import processing.core.*;
 
public class Balloon{
 float balloonX;
 float balloonY;
 float balloonWidth; //diameter
 float balloonRadius; //radius
 
 int[] color = new int[3];
 
 float speed;
 float moveX; //movement in the x axis
 float moveY; //movement in the y axis
 
 static PApplet pa = Sketch.pa;
 
 /*
 * Constructor - Balloon
 * Pre: none
 * Post: creates a balloon with a random color
 *
 * @param none
 */
 Balloon(){
   balloonX = pa.random(100,300); //ballons starts somewhat centered
   balloonY = pa.random(100,300);
   balloonWidth = pa.random(50,100);
   balloonRadius = balloonWidth / 2;
 
   color[0] = Math.round(pa.random(266));
   color[1] = Math.round(pa.random(266));
   color[2] = Math.round(pa.random(266));
 
   speed = pa.random(1,2);
   moveX = pa.random(-2,2);
   moveY = pa.random(-2,2);
 }
 
 /**
 * Instance Method - display
 * Pre: none
 * Post: displays a Balloon
 *
 * @param none
 */
 public void display(){
   pa.fill(color[0], color[1], color[2]);
   pa.ellipse(balloonX, balloonY, balloonWidth, balloonWidth);
 }
 
 /**
 * Instance Method - move
 * Pre: none
 * Post: moves the x and y coordinates of a balloon
 * If the balloon falls of the screen, it bounces back.
 *
 * @param none
 */
 public void move(){
   balloonX += moveX*speed;
   balloonY += moveY*speed;
 
   if (balloonX + balloonRadius > pa.width || balloonX - balloonRadius < 0){
     moveX *= -1;
   }
   if (balloonY + balloonRadius > pa.height || balloonY - balloonRadius <= 0){
     moveY *= -1;
   }
 }
 
 /**
 * Instance Method - popped
 * Pre: none
 * Post: returns whether or not the balloon is popped
 *
 * @param mx   the x coordinate of the mouse click
 * @param my   the y coordinate of the mouse click
 * @return     the state of whether or not the balloon is popped
 */
 public boolean popped(float mx, float my){
   float distance = (float)Math.sqrt(Math.pow(my - balloonY, 2) + (float)Math.pow(mx - balloonX,2));
   return (balloonRadius >= distance);
 }
}
