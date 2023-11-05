class Car implements Comparable<Car>{
    int speed;
    int position;

    Car(int speed, int position) {
        this.speed = speed;
        this.position = position;
    }  

    public int compareTo(Car car) {
        return this.position - car.position;
    }

    public String toString() {
        return this.position + " ";
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        for(int i = 0; i<n; i++) {
            Car car = new Car(speed[i], position[i]);
            cars[i] = car;
        }

        Arrays.sort(cars);

        System.out.println(Arrays.toString(cars));

        int carFleetCount = 0;

        int i = n-1;

        double prevTimeTaken = -1;

        while(i>=0) {
            double currentTimeTaken = (double)(target - cars[i].position) / cars[i].speed;
            if(currentTimeTaken > prevTimeTaken) {
                carFleetCount++;
                prevTimeTaken = currentTimeTaken;
            }
            
            i--;
        }

        return carFleetCount;
    }
}
