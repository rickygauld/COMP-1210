import java.text.DecimalFormat;
import static java.lang.Math.tan;
import static java.lang.Math.toRadians;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
/**
 * Class PentagonalPyramid calculates information concerning a
 * pentagonal pyramid given user inputed variables.
 *
 * Project 08 A
 * @author Will Humphlett - COMP1210 - LLB001
 * @version 3/20/2019
 */
public class PentagonalPyramid {
// instance variables
   private String label = "";
   private double baseEdge = 0;
   private double height = 0;
   private static int pyramidsCreated = 0;
   
/**
 * Constructor for PentagonalPyramid.
 * Creates the object with given parameters.
 *
 * @param labelIn - used
 * @param baseEdgeIn - used
 * @param heightIn - used
 */
   public PentagonalPyramid(String labelIn, double baseEdgeIn, 
      double heightIn) {
      setLabel(labelIn);
      setBaseEdge(baseEdgeIn);
      setHeight(heightIn);
      pyramidsCreated++;
   }
   
   /**
    * Sets the label to the given String.
    *
    * @param labelIn - used
    * @return boolean if label is set
    */
   public boolean setLabel(String labelIn) {
      boolean isLabelSet = false;
      if (labelIn != null) {
         label = labelIn.trim();
         isLabelSet = true;
      }
      // returns a boolean dependant upon if the given paramater is valid
      return isLabelSet;
   }
   
   /**
    * Retrieves the label of the object.
    *
    * @return String the label of the object
    */
   public String getLabel() {
      return label;
   }
   
   /**
    * Sets the base edge to the given double.
    *
    * @param baseEdgeIn - used
    * @return boolean if base is set
    */
   public boolean setBaseEdge(double baseEdgeIn) {
      boolean isBaseSet = false;
      if (baseEdgeIn > 0) {
         baseEdge = baseEdgeIn;
         isBaseSet = true;
      }
      // returns a boolean dependant upon if the given paramater is valid
      return isBaseSet;
   }
   
   /**
    * Retrieves the base edge of the object.
    *
    * @return double the base edge of the object
    */
   public double getBaseEdge() {
      return baseEdge;
   }
   
   /**
    * Sets the height to the given.
    *
    * @param heightIn - used
    * @return boolean if height is set
    */
   public boolean setHeight(double heightIn) {
      boolean isHeightSet = false;
      if (heightIn > 0) {
         height = heightIn;
         isHeightSet = true;
      }
      // returns a boolean dependant upon if the given paramater is valid
      return isHeightSet;
   }
   
   /**
    * Retrieves the height of the object.
    *
    * @return double the height of the object
    */
   public double getHeight() {
      return height;
   }
   
   /**
    * Calculates and returns the surface area of the pentagonal pyramid.
    *
    * @return double calculated surface area
    */
   public double surfaceArea() {
      double surfaceArea = (5.0 / 4.0) * tan(toRadians(54)) * pow(baseEdge, 2)
         + (5 * baseEdge / 2) * sqrt(pow(height, 2)
         + pow(baseEdge * tan(toRadians(54)) / 2, 2));
      return surfaceArea;
   }
   
   /**
    * Calculates and returns the volume of the pentagonal pyramid.
    *
    * @return double calculated surface areavolume
    */
   public double volume() {
      double volume = (5.0 / 12.0) * tan(toRadians(54)) * height 
         * pow(baseEdge, 2);
      return volume;
   }
   
   /**
    * Returns the static number of pyramids created.
    *
    * @return int number of pyramids
    */
   public static int getCount() {
      return pyramidsCreated;
   }
   
   /**
    * Resets the static number of pyramids created to zero.
    */
   public static void resetCount() {
      pyramidsCreated = 0;
   }
   
   /**
    * Determines if a given object is equal to a given pyramid.
    *
    * @param objIn - used
    * @return boolean if object is equal to the pyramid
    */
   public boolean equals(Object objIn) {
      if (!(objIn instanceof PentagonalPyramid)) {
         return false;
      }
      else {
         PentagonalPyramid obj = (PentagonalPyramid) objIn;
         return (label.equalsIgnoreCase(obj.getLabel())
            && Math.abs(baseEdge - obj.getBaseEdge()) < .000001
            && Math.abs(height - obj.getHeight()) < .000001);
      }
   }
   
   /**
    * Hash Code for equals method.
    *
    * @return int zero
    */
   public int hashCode() {
      return 0;
   }
   
   /**
    * Creates and returns the string assigned to a created object.
    *
    * @return String created string
    */
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.0######");
      String output = "PentagonalPyramid \"" + label + "\" ";
      output += "with base edge = " + baseEdge + " ";
      output += "and height = " + height + " units has:";
      output += "\n\tsurface area = " + df.format(surfaceArea()) 
         + " square units";
      output += "\n\tvolume = " + df.format(volume()) + " cubic units";
      return output;
   }
}