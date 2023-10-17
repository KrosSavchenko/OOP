package ru.nsu.savchenko;

import java.util.Arrays;

public class Polynomial {
    int dim;
    int[] odd;

//    Polynomial() {
//        dim = 0;
//        odd = new int[] {};
//    }
//
//    Polynomial(int n) {
//        dim = n;
//        odd = new int[n];
//        Arrays.fill(odd, 0);
//    }

    Polynomial(int[] odds) {
        dim = odds.length;
        int i = dim - 1;
        while (i > 0 && odds[i] == 0) {
            i--;
            dim--;
        }
        odd = new int[dim];
        System.arraycopy(odds, 0, odd, 0, dim);

    }

    public Polynomial plus(Polynomial other) {
        Polynomial res;
        if (this.dim > other.dim) {
            res = new Polynomial(this.odd);
            for (int i = 0; i < other.dim; i++) {
                res.odd[i] += other.odd[i];
            }
        } else {
            res = new Polynomial(other.odd);
            for (int i = 0; i < this.dim; i++) {
                res.odd[i] += this.odd[i];
            }
        }
        return res;
    }

    public Polynomial minus(Polynomial other) {
        Polynomial res = new Polynomial(other.odd);
        for (int i = 0; i < res.dim; i++) {
            res.odd[i] *= -1;
        }

        res = this.plus(res);

        while (res.dim - 1 > 0 && res.odd[res.dim - 1] == 0) {
            res.dim--;
        }
        return res;
    }

    public Polynomial times(Polynomial other) {
        int n = this.dim + other.dim - 1;
        Polynomial res = new Polynomial(n);
        res.dim = n;
        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < other.dim; j++) {
                res.odd[i + j] += this.odd[i] * other.odd[j];
            }
        }
        return res;
    }

    public int evaluate(int num) {
        int res = 0;
        int pow = 1;
        for (int i = 0; i < dim; i++) {
            res += odd[i] * pow;
            pow *= num;
        }
        return res;
    }

    public Polynomial differentiate(int power) {
        if (power <= 0) {
            return new Polynomial(this.odd);
        }
        if (power == 1) {
            if (dim == 0) {
                return new Polynomial();
            }
            if (dim == 1) {
                return new Polynomial(1);
            }
            Polynomial res = new Polynomial(dim - 1);
            for (int i = 0; i < res.dim; i++) {
                res.odd[i] = odd[i + 1] * (i + 1);
            }
            return res;
        } else {
            return this.differentiate(1).differentiate(power - 1);
        }
    }

    public boolean equals(Polynomial other) {
        if (this.dim != other.dim) {
            return false;
        }
        for (int i = 0; i < this.dim; i++) {
            if (this.odd[i] != other.odd[i]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        if (dim == 0) {
            return "";
        }
        String res = "";
        if (dim == 1) {
            res = res.concat(Integer.toString(odd[0]));
            return res;
        }
        if (dim == 2) {
            res = res.concat(odd[1] + "x");
            if (odd[0] != 0) {
                res = res.concat(" + " + odd[0]);
            }
            return res;
        }

        int i = dim - 1;
        res = res.concat(odd[i] + "x^" + i);
        i--;
        while (i > 1) {
            if (odd[i] != 0) {
                res = res.concat(" + " + odd[i] + "x^" + i);
            }
            i--;
        }
        if (odd[1] != 0) {
            res = res.concat(" + " + odd[1] + "x");
        }
        if (odd[0] != 0) {
            res = res.concat(" + " + odd[0]);
        }

        return res;
    }
}