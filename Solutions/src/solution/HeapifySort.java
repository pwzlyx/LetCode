package solution;

public class HeapifySort{

    public int[] sortArray(int[] nums){
        int[] input = buildMaxHeapify(nums);
        int[] res = new int[input.length];
        for (int i = input.length - 1; i >= 0; i--){
            res[i] = input[0];

            input = this.swap(input, 0, i);
            input = this.maxHeapify(input, 0, i);
        }
        return res;
    }

    private int[] maxHeapify(int[] input, int point, int size){
        int l = this.left(point);
        int r = this.right(point);
        int largest = point;
        if (l < size && input[l] > input[point]){
            largest = l;
        }else {
            largest = point;
        }
        if (r < size && input[r] > input[largest]){
            largest = r;
        }
        if (largest != point){
            input = this.swap(input, largest, point);
            maxHeapify(input, largest, size);
        }
        return input;
    }

    private int[] buildMaxHeapify(int[] input){
        int start = input.length/2 - 1;
        for (int i = start;i >= 0; i --){
            this.maxHeapify(input, i, input.length);
        }
        return input;
    }

    private int[] swap(int[] input, int largest, int point) {
        int swap = input[largest];
        input[largest] = input[point];
        input[point] = swap;
        return input;
    }

    private int left(int point){
        return point * 2 + 1;
    }

    private int right(int point){
        return point*2 + 2;
    }


}