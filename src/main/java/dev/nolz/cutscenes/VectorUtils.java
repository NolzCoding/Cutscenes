package dev.nolz.cutscenes;

import org.bukkit.Location;

public class VectorUtils {

    public Location[] interpolateLocation(Location pointA, Location pointB, int count) throws InterpolationError {
        if (pointA.getWorld().equals(pointB.getWorld())) {
            if (count > 2) {
                Location[] locations = new Location[count + 1];
                double xA = pointA.getX();
                double yA = pointA.getY();
                double zA = pointA.getZ();

                double xB = pointB.getX();
                double yB = pointB.getY();
                double zB = pointB.getZ();

                float yawA = pointA.getYaw();
                float yawB = pointB.getYaw();
                float pitchA = pointA.getPitch();
                float pitchB = pointB.getPitch();

                for (int i = 0; i < locations.length; i++) {
                    locations[i] = new Location(pointA.getWorld(),
                            xA + i * (xB - xA) / count,
                            yA + i * (yB - yA) / count,
                            zA + i * (zB - zA) / count,
                            yawA + i * (yawB - yawA) / count,
                            pitchA + i * (pitchB - pitchA) / count
                    );
                }

                return locations;
            }
            else {
                throw new IllegalArgumentException("interpolateLocation: Illegal count!");
            }
        }
        else {
            throw new InterpolationError("interpolateLocation: Point A and point B must be in the same world!");
        }

    }

    public static class InterpolationError extends Exception {

        public InterpolationError(String message) {
            super(message);
        }
    }


}

