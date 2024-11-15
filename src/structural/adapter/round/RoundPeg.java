package structural.adapter.round;

public class RoundPeg {
    /**
     * RoundPegs are compatible with RoundHoles.
     */

        private double radius;

        public RoundPeg() {}

        public RoundPeg(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }
}
