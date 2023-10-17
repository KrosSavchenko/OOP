package ru.nsu.savchenko;

import java.util.Arrays;

/**
 * Class of polynomials.
 */
public class Polynomial {
    int dim;
    int[] odd;

    Polynomial() {
        dim = 0;
        odd = new int[] {};
    }

    Polynomial(int n) {
        dim = n;
        odd = new int[n];
        Arrays.fill(odd, 0);
    }

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

    /**
     * Method for adding two polynomials.
     *
     * @param other A polynomial that is added to the current one.
     * @return A polynomial that is the sum of two polynomials.
     */
    public ru.nsu.savchenko.Polynomial plus(ru.nsu.savchenko.Polynomial other) {
        ru.nsu.savchenko.Polynomial res;
        if (this.dim > other.dim) {
            res = new ru.nsu.savchenko.Polynomial(this.odd);
            for (int i = 0; i < other.dim; i++) {
                res.odd[i] += other.odd[i];
            }
        } else {
            res = new ru.nsu.savchenko.Polynomial(other.odd);
            for (int i = 0; i < this.dim; i++) {
                res.odd[i] += this.odd[i];
            }
        }
        return res;
    }

    /**
     * Method for subtraction two polynomials.
     *
     * @param other A polynomial that is subtracted from the current one.
     * @return A polynomial that is the difference of two polynomials.
     */
    public ru.nsu.savchenko.Polynomial minus(ru.nsu.savchenko.Polynomial other) {
        ru.nsu.savchenko.Polynomial res = new ru.nsu.savchenko.Polynomial(other.odd);
        for (int i = 0; i < res.dim; i++) {
            res.odd[i] *= -1;
        }

        res = this.plus(res);

        while (res.dim - 1 > 0 && res.odd[res.dim - 1] == 0) {
            res.dim--;
        }
        return res;
    }

    /**
     * Method for multiplication two polynomials.
     *
     * @param other A polynomial that is multiplied from the current one.
     * @return A polynomial that is the multiplication of two polynomials.
     */
    public ru.nsu.savchenko.Polynomial times(ru.nsu.savchenko.Polynomial other) {
        int n = this.dim + other.dim - 1;
        ru.nsu.savchenko.Polynomial res = new ru.nsu.savchenko.Polynomial(n);
        res.dim = n;
        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < other.dim; j++) {
                res.odd[i + j] += this.odd[i] * other.odd[j];
            }
        }
        return res;
    }

    /**
     * Method for calculating the value of a polynomial at a point.
     *
     * @param num The value that is substituted into the polynomial.
     * @return Value of a polynomial at a point.
     */
    public int evaluate(int num) {
        int res = 0;
        int pow = 1;
        for (int i = 0; i < dim; i++) {
            res += odd[i] * pow;
            pow *= num;
        }
        return res;
    }

    /**
     * Method that finds the derivative of a degree Power.
     *
     * @param power Degree of derivative to be found.
     * @return Derivative of degree Power
     */
    public ru.nsu.savchenko.Polynomial differentiate(int power) {
        if (power <= 0) {
            return new ru.nsu.savchenko.Polynomial(this.odd);
        }
        if (power == 1) {
            if (dim == 0) {
                return new ru.nsu.savchenko.Polynomial();
            }
            if (dim == 1) {
                return new ru.nsu.savchenko.Polynomial(1);
            }
            ru.nsu.savchenko.Polynomial res = new ru.nsu.savchenko.Polynomial(dim - 1);
            for (int i = 0; i < res.dim; i++) {
                res.odd[i] = odd[i + 1] * (i + 1);
            }
            return res;
        } else {
            return this.differentiate(1).differentiate(power - 1);
        }
    }

    /**
     * Checks if the current polynomial is equal to another.
     *
     * @param other Polynomial with which the current one is compared.
     * @return True if polynomials equal and false else.
     */
    public boolean equals(ru.nsu.savchenko.Polynomial other) {
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

    /**
     * Writes a polynomial as a string.
     *
     * @return String representation of a polynomial.
     */
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