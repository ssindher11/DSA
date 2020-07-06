package Hashing;

import java.util.Arrays;

public class SimpleHash {

    class MyHash {
        int[] mh;
        int cap, size;

        public MyHash(int c) {
            cap = c;
            size = 0;
            mh = new int[cap];
            Arrays.fill(mh, -1);
        }

        public int hash(int k) {
            return k % cap;
        }

        public boolean search(int k) {
            int h = hash(k);
            int i = h;
            while (mh[i] != -1) {
                if (mh[i] == k) {
                    return true;
                }
                i = (i + 1) % cap;
                if (i == h) {
                    return false;
                }
            }
            return false;
        }

        public boolean insert(int key) {
            if (size == cap) {
                return false;
            }
            int i = hash(key);
            while (mh[i] != -1 && mh[i] != -2 && mh[i] != key) {
                i = (i + 1) % cap;
            }
            if (mh[i] == key) {
                return false;
            } else {
                mh[i] = key;
                size++;
                return true;
            }
        }

        public boolean erase(int key) {
            int h = hash(key);
            int i = h;
            while (mh[i] != -1) {
                if (mh[i] == key) {
                    mh[i] = -2;
                    return true;
                }
                i = (i + 1) % cap;
                if (i == h) {
                    return false;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
