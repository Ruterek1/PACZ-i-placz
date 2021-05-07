package GUI;

import Backend.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;

public class Objects {

    public abstract static class Weapon2D extends SVGPath{

        private final Weapon weapon;
        protected Text updateStats;

        public Weapon2D(Weapon weapon) {
            this.weapon = weapon;
            this.updateStats = new Text();
            updateStats.setTranslateX(180);
            updateStats.setTranslateY(100);
        }

        public Weapon getWeapon() {
            return weapon;
        }
        public abstract void setPosition(double x, double y);
        public abstract void updateStats();

    }

    public static class Blade2D extends Weapon2D {

        private final Blade blade;

        public Blade2D(Blade blade) {
            super(blade);
            this.blade = blade;
            setScaleX(-0.004);
            setScaleY(-0.004);
            setRotate(-30);
            setTranslateX(-6280);
            setTranslateY(-2890);
            setContent("M11910 5484 c-14 -3 -97 -16 -185 -30 -231 -36 -755 -142 -1160 -234 -192 -44 -449 -100 -570 -125 -516 -107 -720 -158 -1035 -259 -380 -122 -756 -263 -1065 -399 -178 -78 -295 -114 -425 -129 -140 -16 -158 -11 -209 67 -23 35 -62 84 -85 109 -39 43 -46 46 -92 46 -61 0 -205 -65 -225 -101 -27 -52 -1 -172 88 -396 20 -51 34 -95 31 -98 -5 -5 -121 -46 -538 -187 -146 -49 -384 -130 -530 -180 -146 -49 -382 -130 -525 -178 -143 -49 -474 -161 -735 -250 -261 -89 -592 -201 -735 -250 -143 -48 -295 -100 -338 -114 -154 -53 -386 -160 -582 -271 -598 -337 -780 -424 -1295 -620 -572 -218 -1067 -377 -1543 -496 -70 -17 -127 -35 -127 -39 0 -28 192 -121 380 -184 125 -41 382 -115 458 -131 19 -4 30 -11 26 -17 -4 -7 -2 -8 5 -4 6 4 30 5 53 1 28 -5 36 -10 27 -16 -9 -5 1 -7 26 -4 32 4 36 3 20 -5 -16 -8 -11 -9 20 -5 25 4 35 2 27 -3 -21 -14 248 -53 417 -61 170 -7 451 2 566 18 338 49 584 119 1205 345 557 202 792 289 1220 451 583 221 1001 372 1450 523 261 88 606 204 765 258 253 85 297 103 345 140 30 24 82 56 115 72 61 30 232 82 271 82 18 0 30 -22 79 -142 55 -138 180 -391 231 -467 l24 -37 81 -3 c89 -2 176 18 201 46 47 54 27 198 -54 398 -34 83 -72 178 -86 213 l-26 63 45 45 c86 88 284 205 425 253 33 10 154 38 270 60 260 50 279 57 534 171 389 176 426 190 739 275 219 60 367 114 640 236 151 68 222 93 510 179 218 65 251 78 292 117 20 19 40 25 82 28 86 5 205 42 281 87 119 70 101 75 491 -126 200 -103 352 -176 368 -176 40 0 76 22 129 78 58 61 86 115 104 201 20 96 17 151 -12 233 -46 126 -187 392 -300 563 -99 151 -243 293 -349 345 -60 29 -156 44 -215 34z m-10773 -4510 c-3 -3 -12 -4 -19 -1 -8 3 -5 6 6 6 11 1 17 -2 13 -5z");
        }

        public Blade getBlade() {
            return blade;
        }

        public void setPosition(double x, double y){}
        public void updateStats() {
            updateStats.setText("\nDamage: " + blade.getDamage() +
                                "\nSharpness: " + blade.getSharpness() +
                                "\nEfficiency: " + blade.getEfficiency());
        }
    }

    public static class Blunt2D extends Weapon2D {

        private final Blunt blunt;

        public Blunt2D(Blunt blunt) {
            super(blunt);
            this.blunt = blunt;
            setScaleX(-0.007);
            setScaleY(-0.007);
            setTranslateX(-3050);
            setTranslateY(-6120);
            setContent("M4290 12793 c-422 -21 -919 -99 -1380 -216 l-94 -24 -51 23 c-27 13 -57 24 -66 24 -21 0 -84 -42 -134 -91 -35 -33 -61 -45 -180 -83 -77 -24 -160 -47 -185 -51 -72 -10 -165 -44 -207 -74 -21 -15 -74 -42 -118 -59 -465 -179 -966 -438 -1361 -703 l-102 -68 -20 -118 c-32 -184 -40 -246 -53 -429 -23 -312 19 -681 106 -939 123 -365 348 -664 656 -871 112 -75 97 -73 419 -49 454 34 949 119 1373 237 60 16 110 28 111 26 2 -1 48 -169 104 -373 55 -203 178 -651 272 -995 94 -344 198 -722 230 -840 74 -270 425 -1554 560 -2045 56 -203 128 -467 160 -585 32 -118 122 -447 200 -730 78 -283 154 -562 170 -620 16 -58 92 -337 170 -620 78 -283 168 -612 200 -730 32 -118 82 -298 110 -400 28 -102 64 -232 80 -290 190 -697 274 -989 289 -1010 10 -14 40 -38 66 -55 44 -27 56 -30 129 -29 166 2 287 85 311 215 5 27 -23 147 -124 535 -71 274 -202 778 -291 1119 -89 341 -230 886 -315 1210 -84 325 -222 853 -305 1175 -421 1618 -1341 5141 -1346 5154 -4 11 0 16 13 16 24 0 81 59 127 131 32 52 41 59 113 89 463 190 978 464 1280 679 78 56 78 56 85 111 52 399 51 754 -3 1025 -89 448 -301 831 -672 1212 l-120 123 -76 -2 c-42 -1 -101 -3 -131 -5z");
        }

        public Blunt getBlunt() {
            return blunt;
        }

        public void setPosition(double x, double y){}
        public void updateStats() {
            updateStats.setText("\nDamage: " + blunt.getDamage());
        }
    }

    public static class Neurobalistic2D extends Weapon2D {

        private final Neurobalistic neurobalistic;

        public Neurobalistic2D(Neurobalistic neurobalistic) {
            super(neurobalistic);
            this.neurobalistic = neurobalistic;
        }

        public Neurobalistic getNeurobalistic() {
            return neurobalistic;
        }

        public void setPosition(double x, double y){}
        public void updateStats() {
            updateStats.setText("\nDamage: " + neurobalistic.getDamage() +
                                "\nRange: " + neurobalistic.getRange());
        }
    }

    public static class Pole2D extends Weapon2D {

        private final Pole pole;

        public Pole2D(Pole pole) {
            super(pole);
            this.pole = pole;
        }

        public Pole getPole() {
            return pole;
        }

        public void setPosition(double x, double y){}
        public void updateStats() {
            updateStats.setText("\nDamage: " + pole.getDamage() +
                                "\nRange: " + pole.getRange() +
                                "\nSharpness: " + pole.getSharpness());
        }
    }

    public static class Incendiary2D extends Weapon2D {

        private final Incendiary incendiary;

        public Incendiary2D(Incendiary incendiary) {
            super(incendiary);
            this.incendiary = incendiary;
            setScaleX(-0.08);
            setScaleY(0.08);
            setTranslateX(-120);
            setTranslateY(60);
            setContent("M447.269,110.933L341.335,5c-3.207-3.191-7.543-4.988-12.067-5H153.602c-9.421,0.011-17.056,7.645-17.067,17.067V51.2c0.011,9.421,7.645,17.056,17.067,17.067v51.2h-7.392c-10.052,0.01-18.198,8.156-18.208,18.208v32.992H97.144c-9.668,0.129-18.163,6.443-21.075,15.662C66.03,219.913,60.59,254.703,59.896,289.748c-0.006,0.135-0.078,0.249-0.078,0.385c0,0.11,0.059,0.202,0.063,0.312c-0.048,2.299-0.146,4.648-0.146,6.896c-0.195,36.386,6.671,72.465,20.215,106.236c0.153,0.505,0.354,0.994,0.602,1.46C107.19,468.932,156.718,512,213.335,512s106.145-43.067,132.783-106.96c0.248-0.467,0.449-0.957,0.603-1.463c13.544-33.771,20.409-69.849,20.215-106.235c0-2.248-0.099-4.597-0.146-6.896c0.004-0.11,0.063-0.201,0.063-0.312c0-0.137-0.071-0.25-0.078-0.385c-0.693-35.045-6.134-69.835-16.172-103.419c-2.912-9.22-11.407-15.533-21.075-15.662h-30.858v-32.992c-0.01-10.052-8.156-18.198-18.208-18.208h-7.392v-51.2h32.417l78.517,77.55v144.317c0.011,9.421,7.646,17.056,17.067,17.067h34.133c9.421-0.011,17.056-7.645,17.067-17.067V123C452.281,118.471,450.48,114.126,447.269,110.933z M92.269,191.713c0.606-2.233,2.566-3.833,4.875-3.979h47.014c-4.392,31.108-6.872,62.455-7.425,93.867H77.218C78.44,251.124,83.497,220.924,92.269,191.713z M76.825,298.667h59.72c0.009,31.444,2.565,62.835,7.642,93.867H93.737C82.528,362.508,76.8,330.715,76.825,298.667z M101.066,409.6h46.336c4.723,27.496,14.481,53.884,28.783,77.839C145.336,474.793,118.901,446.841,101.066,409.6z M273.046,298.667c0.08,31.453-2.523,62.856-7.782,93.867H161.407c-5.259-31.011-7.863-62.413-7.782-93.867H273.046z M153.811,281.6c0.553-31.417,3.088-62.769,7.591-93.867h103.867c4.503,31.098,7.038,62.449,7.591,93.867H153.811z M213.335,494.933c-17.811,0-36.891-32.308-48.572-85.333h97.143C250.226,462.625,231.147,494.933,213.335,494.933z M250.485,487.439c14.302-23.954,24.06-50.342,28.783-77.839h46.337C307.77,446.841,281.334,474.793,250.485,487.439z M329.527,187.733c2.309,0.146,4.269,1.746,4.875,3.979c8.772,29.211,13.829,59.412,15.05,89.888h-59.515c-0.553-31.411-3.033-62.759-7.425-93.867H329.527z M290.125,298.667h59.72c0.025,32.049-5.703,63.842-16.912,93.867h-50.451C287.56,361.502,290.116,330.111,290.125,298.667z M280.46,136.533c0.303,0,0.593,0.12,0.808,0.334c0.214,0.214,0.334,0.505,0.334,0.808v32.992H145.069v-32.992c0-0.303,0.12-0.593,0.334-0.808c0.214-0.214,0.505-0.334,0.808-0.334H280.46z M170.669,119.467v-51.2h85.333v51.2H170.669z M435.202,290.133h-34.133V145.817c-0.014-4.559-1.836-8.925-5.067-12.142l-78.509-77.538c-3.185-3.175-7.503-4.951-12-4.937H153.602V17.067h175.667L435.202,123V290.133z"
            );
        }

        public Incendiary getIncendiary() {
            return incendiary;
        }

        public void setPosition(double x, double y){}
        public void updateStats() {
            updateStats.setText("\nApply Range: " + incendiary.getApplyRange() +
                                "\nIgnition Range: " + incendiary.getIgnitionRange() +
                                "\nExpiration Time: " + incendiary.getExpirationTime() +
                                "\nDPS: " + incendiary.getDPS());
        }
    }

    public static class Explosive2D extends Weapon2D {

        private final Explosive explosive;

        public Explosive2D(Explosive explosive) {
            super(explosive);
            this.explosive = explosive;
            setScaleX(-0.08);
            setScaleY(0.08);
            setContent("M447.269,110.933L341.335,5c-3.207-3.191-7.543-4.988-12.067-5H153.602c-9.421,0.011-17.056,7.645-17.067,17.067V51.2c0.011,9.421,7.645,17.056,17.067,17.067v51.2h-7.392c-10.052,0.01-18.198,8.156-18.208,18.208v32.992H97.144c-9.668,0.129-18.163,6.443-21.075,15.662C66.03,219.913,60.59,254.703,59.896,289.748c-0.006,0.135-0.078,0.249-0.078,0.385c0,0.11,0.059,0.202,0.063,0.312c-0.048,2.299-0.146,4.648-0.146,6.896c-0.195,36.386,6.671,72.465,20.215,106.236c0.153,0.505,0.354,0.994,0.602,1.46C107.19,468.932,156.718,512,213.335,512s106.145-43.067,132.783-106.96c0.248-0.467,0.449-0.957,0.603-1.463c13.544-33.771,20.409-69.849,20.215-106.235c0-2.248-0.099-4.597-0.146-6.896c0.004-0.11,0.063-0.201,0.063-0.312c0-0.137-0.071-0.25-0.078-0.385c-0.693-35.045-6.134-69.835-16.172-103.419c-2.912-9.22-11.407-15.533-21.075-15.662h-30.858v-32.992c-0.01-10.052-8.156-18.198-18.208-18.208h-7.392v-51.2h32.417l78.517,77.55v144.317c0.011,9.421,7.646,17.056,17.067,17.067h34.133c9.421-0.011,17.056-7.645,17.067-17.067V123C452.281,118.471,450.48,114.126,447.269,110.933z M92.269,191.713c0.606-2.233,2.566-3.833,4.875-3.979h47.014c-4.392,31.108-6.872,62.455-7.425,93.867H77.218C78.44,251.124,83.497,220.924,92.269,191.713z M76.825,298.667h59.72c0.009,31.444,2.565,62.835,7.642,93.867H93.737C82.528,362.508,76.8,330.715,76.825,298.667z M101.066,409.6h46.336c4.723,27.496,14.481,53.884,28.783,77.839C145.336,474.793,118.901,446.841,101.066,409.6z M273.046,298.667c0.08,31.453-2.523,62.856-7.782,93.867H161.407c-5.259-31.011-7.863-62.413-7.782-93.867H273.046z M153.811,281.6c0.553-31.417,3.088-62.769,7.591-93.867h103.867c4.503,31.098,7.038,62.449,7.591,93.867H153.811z M213.335,494.933c-17.811,0-36.891-32.308-48.572-85.333h97.143C250.226,462.625,231.147,494.933,213.335,494.933z M250.485,487.439c14.302-23.954,24.06-50.342,28.783-77.839h46.337C307.77,446.841,281.334,474.793,250.485,487.439z M329.527,187.733c2.309,0.146,4.269,1.746,4.875,3.979c8.772,29.211,13.829,59.412,15.05,89.888h-59.515c-0.553-31.411-3.033-62.759-7.425-93.867H329.527z M290.125,298.667h59.72c0.025,32.049-5.703,63.842-16.912,93.867h-50.451C287.56,361.502,290.116,330.111,290.125,298.667z M280.46,136.533c0.303,0,0.593,0.12,0.808,0.334c0.214,0.214,0.334,0.505,0.334,0.808v32.992H145.069v-32.992c0-0.303,0.12-0.593,0.334-0.808c0.214-0.214,0.505-0.334,0.808-0.334H280.46z M170.669,119.467v-51.2h85.333v51.2H170.669z M435.202,290.133h-34.133V145.817c-0.014-4.559-1.836-8.925-5.067-12.142l-78.509-77.538c-3.185-3.175-7.503-4.951-12-4.937H153.602V17.067h175.667L435.202,123V290.133z"
            );
        }

        public Explosive getExplosive() {
            return explosive;
        }

        public void setPosition(double x, double y) {
            setTranslateX(x-220);
            setTranslateY(y-240);
        }
        public void updateStats() {
            updateStats.setText("\nApply Range: " + explosive.getApplyRange() +
                                "\nIgnition Range: " + explosive.getIgnitionRange() +
                                "\nCentral Damage: " + explosive.getCentralDamage());
        }
    }

    public static class Poison2D extends Weapon2D {

        private final Poison poison;

        public Poison2D(Poison poison) {
            super(poison);
            this.poison = poison;
            setScaleX(0.4);
            setScaleY(0.4);
            setTranslateX(80);
            setTranslateY(250);
            setContent("m106.88 5.2544l-33.271 22.882 47.361 4.493c-0.58-2.411-1.32-4.796-2.17-7.138l-15.11 2.358-0.19-1.115 14.34-3.888c-0.64-1.565-1.4-3.078-2.16-4.589l-29.228 7.074-0.478-0.605 28.426-8.987c-0.67-1.194-1.44-2.326-2.2-3.474l-14.498 4.717-0.765-0.988 13.763-5.991c-1.19-1.6393-2.45-3.2367-3.82-4.7486zm-65.936 17.018c-4.131-0.014-8.39 0.75-12.652 2.295l-18.292 18.388c20.396 5.889 41.126 4.849 60.136 0l-17.337-18.325c-3.741-1.573-7.724-2.343-11.855-2.358zm29.351 5.673l-11.313 1.083 9.082 9.975 5.067-7.425-2.836-3.633zm-60.295 18.037v69.278c14.787 7.88 51.622 7.4 60.136 0v-7.61c-7.873 2.19-26.078 4.77-40.537 0.73l-0.542-49.013v-1.466c16.468 2.279 27.731 2.676 41.079-0.096v-11.122c-19.01 4.157-39.74 4.495-60.136-0.701zm20.714 14.213v46.565c16.265 4.15 26.623 1.66 39.422-0.77v-5.61c-2.387-0.894-4.126-1.538-6.693-2.484-3.172 1.228-8.56 3.314-9.082 3.504 0.052 0.23 0.216 0.42 0.191 0.67-0.112 1.11-1.056 1.95-2.04 1.85-0.983-0.1-1.673-1.09-1.561-2.2 0.022-0.22 0.177-0.32 0.255-0.51-0.841-0.23-1.44-1.04-1.339-2.04 0.112-1.105 0.961-1.916 1.944-1.816 0.675 0.068 1.163 0.558 1.402 1.211 0.161-0.052 4.393-1.661 5.96-2.231-1.567-0.57-5.799-2.147-5.96-2.199-0.239 0.653-0.727 1.143-1.402 1.211-0.983 0.1-1.832-0.711-1.944-1.816-0.101-1.003 0.498-1.807 1.339-2.04-0.078-0.191-0.233-0.292-0.255-0.51-0.112-1.105 0.578-2.067 1.561-2.167 0.984-0.099 1.928 0.711 2.04 1.817 0.025 0.25-0.139 0.408-0.191 0.637 0.522 0.191 5.91 2.309 9.082 3.537 2.567-0.946 4.305-1.59 6.693-2.485v-8.86c-0.272 0.283-1.02 0.9-1.02 1.02 0 4.939-2.587 8.923-5.8 8.923s-5.832-3.984-5.832-8.923c0-0.666-7.617-5.221-7.617-7.935 0-3.643 5.835-6.597 13.003-6.597 2.763 0 5.162 0.526 7.266 1.275v-11.027c-12.799 2.079-25.93 3.118-39.422 0zm27.79 15.966c-1.205 0-2.231 0.825-2.231 1.817 0 0.991 1.026 1.785 2.231 1.785 1.204 0 2.167-0.794 2.167-1.785 0-0.992-0.963-1.817-2.167-1.817zm8.923 0c-1.205 0-2.167 0.825-2.167 1.817 0 0.991 0.962 1.785 2.167 1.785s2.199-0.794 2.199-1.785c0-0.992-0.994-1.817-2.199-1.817zm2.709 19.153c-0.707 0.273-1.495 0.575-2.646 1.02 1.151 0.445 1.939 0.779 2.646 1.052v-2.072z");
        }

        public Poison getIncendiary() {
            return poison;
        }

        public void setPosition(double x, double y){}
        public void updateStats() {
            updateStats.setText("\nApply Range: " + poison.getApplyRange() +
                                "\nIgnition Range: " + poison.getIgnitionRange() +
                                "\nExpiration Time: " + poison.getExpirationTime() +
                                "\nDPS: " + poison.getDPS());
        }
    }

    public static class Shotgun2D extends Weapon2D {

        private final Shotgun shotgun;

        public Shotgun2D(Shotgun shotgun) {
            super(shotgun);
            this.shotgun = shotgun;
            updateStats();
            setScaleX(0.01);
            setScaleY(-0.01);
            setRotate(45);
            setContent("M8780 11133 c-2918 -2884 -3987 -3942 -4590 -4537 -440 -435 -585 -584 -583 -600 1 -16 -10 -28 -39 -44 -43 -26 -92 -95 -110 -157 -14 -47 -15 -48 -170 -267 -118 -165 -121 -168 -266 -283 -129 -102 -148 -121 -159 -158 -19 -64 -17 -69 24 -41 65 44 119 44 148 1 14 -23 2 -47 -288 -577 l-303 -554 -140 -48 c-76 -26 -150 -56 -164 -66 -32 -24 -2107 -2428 -2126 -2464 -19 -36 -18 -76 4 -116 25 -48 1307 -1209 1344 -1217 42 -10 82 3 110 33 17 18 132 301 353 867 180 462 367 941 415 1065 48 124 152 389 230 590 78 201 151 384 162 407 24 50 52 77 73 69 20 -7 44 -63 52 -122 6 -43 9 -48 52 -68 36 -16 65 -21 136 -21 80 0 97 4 157 32 37 17 89 46 115 64 53 36 204 178 234 221 l20 27 -64 63 c-145 143 -247 356 -247 514 0 43 3 52 15 48 22 -9 142 14 200 38 86 36 208 124 287 206 192 201 257 433 156 556 -41 51 -98 76 -171 76 l-59 0 52 62 c179 215 145 181 2924 2926 358 354 661 659 673 679 56 93 51 205 -14 290 l-35 46 118 117 c226 222 1081 1066 1504 1485 234 231 621 613 860 850 239 236 616 610 838 830 l402 400 -222 222 -223 222 -1685 -1666z m-5050 -6541 c135 -68 80 -316 -115 -517 -125 -130 -285 -215 -402 -215 -61 0 -61 -1 -38 100 18 75 26 99 68 193 l30 68 26 -25 c38 -37 132 -76 193 -81 l53 -5 -42 15 c-87 33 -174 141 -159 197 3 13 44 77 90 143 73 103 90 122 123 132 57 17 133 15 173 -5z");
        }

        public void setPosition(double x, double y) {
            setTranslateX(x-5410);
            setTranslateY(y-6380);
        }

        public void updateStats() {
            updateStats.setText("Magazine: " + shotgun.getMagazine() +
                                "\nRange: " + shotgun.getRange() +
                                "\nAmmo: " + shotgun.getAmmo() +
                                "\nBullet Damage: " + shotgun.getBulletDamage() +
                                "\nBarrels: " + shotgun.getBarrels());
        }
    }

    public static class Handgun2D extends Weapon2D {

        private final Handgun handgun;

        public Handgun2D(Handgun handgun) {
            super(handgun);
            this.handgun = handgun;
            updateStats();
            setScaleX(0.1);
            setScaleY(0.1);
            setContent("M 29.26112,394.6188 C 3.8780885,392.16642 0,387.87869 0,362.26686 0,317.73428 10.249667,271.72088 28.592836,233.90625 37.759188,215.00972 45.815612,202.94223 66.39757,177.27959 76.007687,165.29722 78.75,160.40804 78.75,155.25689 c 0,-4.83111 4.095692,-9.00689 8.834135,-9.00689 2.355768,0 3.353365,-0.41835 3.353365,-1.40625 0,-0.77344 0.398218,-1.40625 0.884929,-1.40625 0.48671,0 1.997433,-2.47898 3.357155,-5.50885 4.715879,-10.50838 6.165746,-11.41213 48.257916,-30.0811 33.71339,-14.952749 31.31366,-13.722616 37.11721,-19.026731 l 5.07029,-4.633961 0.0163,-6.234055 c 0.009,-3.428729 0.64177,-9.18702 1.40625,-12.796202 1.83192,-8.648569 1.83472,-8.628465 -1.44011,-10.321948 -5.49866,-2.843448 -15.81146,-13.75761 -24.37357,-25.794808 -8.85405,-12.447631 -9.53876,-13.079679 -23.73469,-21.9089336 -2.49387,-1.5510822 -2.5623,-1.7572858 -1.11414,-3.3574872 2.16622,-2.3936399 8.64594,-3.85128508 12.87715,-2.89677913 4.07658,0.91962243 6.23076,2.23484343 16.7376,10.21904293 13.90233,10.564456 21.65211,13.279312 37.90686,13.279312 9.72143,0 10.15459,-0.08896 13.55786,-2.784397 4.36236,-3.455058 5.9127,-4.044528 21.24702,-8.078589 9.22999,-2.428172 13.32861,-3.095321 16.1976,-2.636553 3.40577,0.544605 3.84086,0.404666 3.84086,-1.2353397 0,-1.0172359 0.75771,-2.5352309 1.68379,-3.3733224 1.51426,-1.3703869 9.04162,-1.5722044 74.76562,-2.0045519 40.19501,-0.264412 78.76629,-0.5933049 85.71394,-0.730873 l 12.63211,-0.250124 0.81329,2.8125 c 0.44732,1.546875 1.5749,4.289063 2.50574,6.09375 l 1.69243,3.28125 215.48717,0 215.48716,0 14.59679,-6.3863871 c 12.62808,-5.5250349 15.22017,-6.3469181 19.21875,-6.09375 l 4.62196,0.2926371 1.76905,5.740812 1.76905,5.740812 5.73095,0.519965 c 4.23456,0.384198 6.11741,0.170368 7.21102,-0.818937 2.29524,-2.076329 10.75515,-1.759935 13.00132,0.486241 9.17108,9.171035 8.17761,41.986986 -1.71857,56.768607 -2.34899,3.508629 -2.83616,3.76861 -7.56879,4.039141 -3.82282,0.218524 -5.25788,-0.06769 -5.87583,-1.171875 C 921.54986,73.268894 897.6951,73.125 680.08025,73.125 c -213.70325,0 -241.45099,0.161288 -241.92872,1.40625 -0.29681,0.773437 -1.33825,1.40625 -2.31433,1.40625 -1.50464,0 -1.7747,0.713309 -1.7747,4.6875 l 0,4.6875 23.25832,0 c 18.99882,0 23.59159,-0.252079 25.07812,-1.376435 2.57329,-1.946336 15.67923,-1.968938 17.28856,-0.02981 1.57526,1.89808 9.67474,1.89808 11.25,0 1.65487,-1.993995 15.22013,-1.993995 16.875,0 1.50611,1.814754 8.31233,1.795835 10.72606,-0.02981 2.27057,-1.717377 14.61725,-1.908134 16.27394,-0.251437 1.48175,1.48175 1.48175,13.143253 0,14.625 -1.37252,1.372519 -14.4497,1.532972 -15.28125,0.1875 -0.75494,-1.221525 -11.43256,-1.221525 -12.1875,0 -0.75548,1.222406 -14.24452,1.222406 -15,0 -0.75494,-1.221525 -11.43256,-1.221525 -12.1875,0 -0.75585,1.222997 -17.05665,1.222997 -17.8125,0 C 481.98204,97.852247 472.80277,97.5 457.91342,97.5 l -23.85092,0 0,14.41751 0,14.41752 2.57812,1.10425 c 1.41797,0.60734 3.42746,2.45149 4.46553,4.09811 1.48688,2.35853 2.63083,3.0556 5.39063,3.28483 3.47622,0.28872 3.50322,0.32305 3.50322,4.45313 0,3.82551 -0.19145,4.16215 -2.36695,4.16215 -1.60458,0 -2.62999,0.69183 -3.18359,2.14791 -1.03709,2.72776 -2.69227,4.09471 -5.94733,4.91167 -1.41963,0.35631 -3.24273,1.7678 -4.05133,3.13665 -2.98677,5.0562 -18.12349,12.38875 -25.69542,12.4474 -4.29647,0.0333 -4.88116,0.34495 -9.13221,4.86784 -4.965,5.28252 -13.58197,16.46475 -19.85205,25.76199 -7.60474,11.27627 -9.60735,17.74782 -11.26837,36.41434 -1.94341,21.83999 -9.44786,33.13172 -28.40724,42.74353 -15.4617,7.83861 -24.88204,9.5147 -50.13268,8.91976 -20.1684,-0.4752 -27.08757,-1.9132 -40.32625,-8.38097 -15.22544,-7.43842 -24.84034,-19.22122 -29.36098,-35.98112 -4.02682,-14.92905 -10.56419,-25.48534 -18.23047,-29.43779 -5.14352,-2.65182 -13.91897,-2.54962 -22.73923,0.26482 -3.73332,1.19125 -7.07316,2.45123 -7.42188,2.79995 -0.34871,0.34871 -1.79183,0.63402 -3.20693,0.63402 -2.63345,0 -7.42709,4.50298 -7.42709,6.97675 0,2.21948 -3.85053,6.14825 -6.0258,6.14825 -3.08916,0 -11.31448,9.09243 -14.62239,16.16388 -3.89236,8.32084 -5.04778,17.90956 -3.73765,31.01855 1.27254,12.73275 6.08103,38.4733 11.8223,63.28638 7.15279,30.91352 7.39964,38.92586 1.3846,44.94089 -8.3243,8.32431 -38.68027,12.53448 -88.505015,12.27506 -13.494137,-0.0703 -28.031353,-0.46558 -32.304925,-0.87846 z M 320.17192,273.746 c 9.69573,-2.47976 21.92178,-8.38177 26.93461,-13.00243 4.81454,-4.4379 9.57667,-13.92118 11.08329,-22.07126 1.30782,-7.07465 -0.1312,-16.36704 -3.98949,-25.76189 -6.27389,-15.27678 -9.75783,-18.28299 -22.32808,-19.26635 -5.09997,-0.39896 -8.98432,-0.30688 -9.65553,0.2289 -0.61763,0.493 -4.0761,1.38747 -7.68547,1.98769 -15.18701,2.52556 -27.26983,6.98979 -32.57543,12.03563 -3.93493,3.74227 -6.48058,11.59974 -6.60429,20.38496 -0.0902,6.40418 0.25693,8.1996 2.37575,12.28822 1.36474,2.63354 3.55941,6.06944 4.87704,7.63534 3.08774,3.66958 3.01741,4.10189 -0.46958,2.88632 -5.75677,-2.00682 -13.95239,-15.68842 -13.98915,-23.3532 -0.0219,-4.58436 5.53319,-26.19289 7.92063,-30.80969 0.78857,-1.52495 1.43378,-3.02785 1.43378,-3.3398 0,-1.2648 -10.19506,-5.00742 -15.24408,-5.59612 l -5.40033,-0.62966 -0.57857,2.89286 c -0.48371,2.41856 -1.64372,3.45258 -7.07518,6.30673 -12.20157,6.41174 -18.76307,16.44328 -20.45426,31.27146 -0.44565,3.90739 -0.92578,7.50501 -1.06697,7.9947 -0.65173,2.26049 1.42138,9.72579 4.09261,14.73752 7.11908,13.35676 22.8984,22.38727 43.85178,25.09637 10.07079,1.30208 36.38999,0.16989 44.54692,-1.9163 z");
        }

        public void setPosition(double x, double y) {
            setTranslateX(x-430);
            setTranslateY(y-170);
        }

        public void updateStats() {
            updateStats.setText("Magazine: " + handgun.getMagazine() +
                                "\nRange: " + handgun.getRange() +
                                "\nAmmo: " + handgun.getAmmo() +
                                "\nBullet Damage: " + handgun.getBulletDamage());
        }
    }

    public static class Rifle2D extends Weapon2D {

        private final Rifle rifle;

        public Rifle2D(Rifle rifle) {
            super(rifle);
            this.rifle = rifle;
            updateStats();
            setScaleX(0.3);
            setScaleY(0.3);
            setContent("m592.12 14.264v-0.264h-4.331v-0.667h-0.836v0.667h-0.5v-0.667h-24.667v0.833h-4.5v-14.166h-1.57c-0.225 0.482-0.998 0.84-1.927 0.84s-1.702-0.357-1.927-0.84h-1.742v14.167h-28.156l-0.011-0.5-7-0.167-1.667-3.167h2.167v-2.166h-3.307l-0.526-1-5.438-0.279c-0.242-0.709-0.905-1.222-1.696-1.222h-76.214c-0.068-0.931-0.837-1.667-1.786-1.667h-0.4c-0.89 0-1.624 0.647-1.77 1.496l-119.17-1.995-0.167-0.667-13.17 0.167-1 0.333-14.166-0.5-5-0.5-1.834-0.5 0.667 2.333 1.5 0.167 0.333 1.333 3.834 0.167 0.333-1.333 5.167 0.333-7.79 2.167h-2.534v-1.833h-4.833v1.833h-7.333v-0.5h-38.244c-0.277-0.637 0.09-1.083-0.648-1.083h-3.703c-0.233-0.724-0.904-1.25-1.706-1.25h-3.066c-0.801 0-1.472 0.527-1.705 1.25h-65.044c-0.994 0-1.8 0.806-1.8 1.8v2.767c-0.637 0.277-1.083 0.911-1.083 1.65v9.293c-8.749 2.269-30.873 9.283-33.833 10.406-4.833 1.833-7.833 0.833-12.667-1-6.123-2.323-16.667-2.833-20.667-2.667s-67.5 1.338-69.667 2.005-1.834-0.5-3.167-0.167-2.5 2.333-2 4.667 3.5 13.5 4.667 21.5 2.833 20.333 2.833 22.667 1.667 5.834 3.5 4.167c1.667 0.667 4.5 0.167 7.167-0.833s28.413-7.762 30.58-8.429c1.369-0.421 3.135-1.838 4.587-2.91 0.864 0.854 1.555 1.458 2.19 1.686-0.143 0.473-0.202 0.987-0.145 1.492l0.187 1.247c0.159 1.408 1.133 2.203 2.175 1.776l1.281-0.76c1.043-0.427 1.759-1.915 1.6-3.323l-0.187-1.247c-0.098-0.871-0.509-1.504-1.054-1.762 0.106-0.184 0.21-0.374 0.305-0.578 1.012-0.033 2.032-0.103 2.893-0.288 2.333-0.5 17.087-4.57 19.253-5.07s6.833-1 10-0.333 8.667 1.167 11.333-1.5 13.14-10.673 17.14-13.34c3.43-2.286 9.286-5.274 21.643-6.999l0.357 0.5h3.833s3.667 0.5 3.667 4.667-0.5 10.667 12 10.667c12.5 0 15.167-5.833 15.167-8 0-5.502 1.833-8.833 5-8.833 0.596 0 0.994-0.065 1.269-0.167h23.402c-0.261 1.204-0.651 1.75-1.171 2.167-0.833 0.667-0.167 1 0 1.5s-0.167 5.833-3.167 9.833l0.5 0.667c2.833-2.833 3.667-6.333 3.833-7.833s0.5-1.666 1.333-2.333c0.573-0.458 1.617-2.332 2.053-4h0.8c-0.863 9.146-0.837 19.137 0.814 34l1.5 0.167 0.333 1.167 37.5-5.5 1.333-0.833-0.667-0.667c-1.464-13.011-1.813-23.314-0.9-30h1.438l0.461 0.667c5.333 0.333 14.167-1.833 22-2.5 7.834-0.667 50.5-6.667 76.5-7.333 25.755-0.66 60.001-2.301 73.118-2.008 0.255 0.684 0.909 1.173 1.682 1.173h0.4c0.792 0 1.458-0.515 1.698-1.227l1.102 1.561 3.5-0.833-1.333-1 0.167-1.333h108.83v3.33h6.999v-3.333h25.167v0.833h5.333v-3.167h-5.333v1.167h-25.167v-3.333h14.333v1h24.667v-1h0.5v1h0.836v-1h4.331v-0.168c0.464-0.021 0.836-0.397 0.836-0.867v-5c0.02-0.47-0.36-0.846-0.82-0.868zm-532.3 57.682l0.091 0.402c0.125 1.11-0.473 2.297-1.335 2.65l-0.369 0.386c-0.863 0.354-1.664-0.259-1.79-1.369l-0.091-0.402c-0.061-0.538 0.051-1.093 0.278-1.563 0.607-0.193 1.41-0.697 2.139-1.541 0.553 0.117 0.988 0.647 1.077 1.437zm116.13-22.445c0 0.667-1 6.667-13 6.667s-11.167-4.667-11.167-6.167 0.833-2.833 1.5-3.333 2-1 2-1v1.167h2.167v-3.5c1.667-1.167 2.5-1.667 3.333-1.667s2.833 0 2.833 0c-1.833 2.833-2.167 4.833-2.167 6.333s0.5 4.167 3.667 6.667l0.833-0.667c-2.333-2.667-3-4.333-3-6s1.333-5.334 3.667-6.667h5.167c3.167 0 4.167 2.5 4.167 4.667v3.5zm182.75-37.668h-7.333c-0.967 0-1.75-0.784-1.75-1.75s0.783-1.75 1.75-1.75h7.333c0.967 0 1.75 0.784 1.75 1.75s-0.78 1.75-1.75 1.75zm17.5 0h-7.333c-0.967 0-1.75-0.784-1.75-1.75s0.783-1.75 1.75-1.75h7.333c0.967 0 1.75 0.784 1.75 1.75s-0.78 1.75-1.75 1.75zm17.5 0h-7.333c-0.967 0-1.75-0.784-1.75-1.75s0.783-1.75 1.75-1.75h7.333c0.967 0 1.75 0.784 1.75 1.75s-0.78 1.75-1.75 1.75zm17.5 0h-7.333c-0.967 0-1.75-0.784-1.75-1.75s0.783-1.75 1.75-1.75h7.333c0.967 0 1.75 0.784 1.75 1.75s-0.78 1.75-1.75 1.75zm83.51-3.166c1.059 0 1.917 0.858 1.917 1.917s-0.858 1.917-1.917 1.917-1.917-0.858-1.917-1.917 0.86-1.917 1.92-1.917zm-3.67 12h2.334c0.506 0 0.916 0.41 0.916 0.917s-0.41 0.917-0.916 0.917h-2.334c-0.506 0-0.916-0.41-0.916-0.917s0.41-0.917 0.92-0.917zm-4.17-12c1.059 0 1.917 0.858 1.917 1.917s-0.858 1.917-1.917 1.917-1.917-0.858-1.917-1.917 0.86-1.917 1.92-1.917zm-4.5 12h2.334c0.506 0 0.916 0.41 0.916 0.917s-0.41 0.917-0.916 0.917h-2.334c-0.506 0-0.916-0.41-0.916-0.917s0.41-0.917 0.92-0.917zm-3.33-12c1.059 0 1.917 0.858 1.917 1.917s-0.858 1.917-1.917 1.917-1.917-0.858-1.917-1.917 0.86-1.917 1.92-1.917zm-3 12c0.506 0 0.916 0.41 0.916 0.917s-0.41 0.917-0.916 0.917h-2.334c-0.506 0-0.916-0.41-0.916-0.917s0.41-0.917 0.916-0.917h2.33zm-4.84-12c1.059 0 1.917 0.858 1.917 1.917s-0.858 1.917-1.917 1.917-1.917-0.858-1.917-1.917 0.87-1.917 1.92-1.917zm-2.91 12.916c0 0.506-0.41 0.917-0.916 0.917h-2.334c-0.506 0-0.916-0.41-0.916-0.917s0.41-0.917 0.916-0.917h2.334c0.51 0.001 0.92 0.411 0.92 0.917zm-4.92-12.916c1.059 0 1.917 0.858 1.917 1.917s-0.858 1.917-1.917 1.917-1.917-0.858-1.917-1.917 0.86-1.917 1.92-1.917zm-3.75 12.916c0 0.506-0.41 0.917-0.916 0.917h-2.334c-0.506 0-0.916-0.41-0.916-0.917s0.41-0.917 0.916-0.917h2.334c0.51 0.001 0.92 0.411 0.92 0.917zm-4.08-12.916c1.059 0 1.917 0.858 1.917 1.917s-0.858 1.917-1.917 1.917-1.917-0.858-1.917-1.917 0.86-1.917 1.92-1.917zm-4.59 12.916c0 0.506-0.41 0.917-0.916 0.917h-2.334c-0.506 0-0.916-0.41-0.916-0.917s0.41-0.917 0.916-0.917h2.334c0.51 0.001 0.92 0.411 0.92 0.917zm-3.25-12.916c1.059 0 1.917 0.858 1.917 1.917s-0.858 1.917-1.917 1.917-1.917-0.858-1.917-1.917 0.86-1.917 1.92-1.917zm-5.42 12.916c0 0.506-0.41 0.917-0.916 0.917h-2.334c-0.506 0-0.916-0.41-0.916-0.917s0.41-0.917 0.916-0.917h2.334c0.52 0.001 0.92 0.411 0.92 0.917zm-2.41-12.916c1.059 0 1.917 0.858 1.917 1.917s-0.858 1.917-1.917 1.917-1.917-0.858-1.917-1.917 0.86-1.917 1.92-1.917zm100.58 15.833h-108.69l0.167-1.333h67.388c0.771 0 1.423-0.486 1.68-1.167h0.583l0.037 1 3.5-0.333 0.83-0.667 16.167-0.333-0.011-0.5h18.345v3.333zm34.67-0.417c0.506 0 0.916 0.411 0.916 0.917s-0.41 0.917-0.916 0.917c-0.507 0-0.917-0.411-0.917-0.917s0.41-0.917 0.92-0.917zm-8.08-3.993c0 0.368-0.299 0.667-0.667 0.667-0.367 0-0.666-0.298-0.666-0.667v-5.667c0-0.368 0.299-0.667 0.666-0.667 0.368 0 0.667 0.298 0.667 0.667v5.667zm3.08 0c0 0.368-0.299 0.667-0.667 0.667-0.367 0-0.666-0.298-0.666-0.667v-5.667c0-0.368 0.299-0.667 0.666-0.667 0.368 0 0.667 0.298 0.667 0.667v5.667zm3.08 0c0 0.368-0.299 0.667-0.667 0.667-0.367 0-0.666-0.298-0.666-0.667v-5.667c0-0.368 0.299-0.667 0.666-0.667 0.368 0 0.667 0.298 0.667 0.667v5.667zm3.09 0c0 0.368-0.299 0.667-0.667 0.667-0.367 0-0.666-0.298-0.666-0.667v-5.667c0-0.368 0.299-0.667 0.666-0.667 0.368 0 0.667 0.298 0.667 0.667v5.667zm3.08 0c0 0.368-0.299 0.667-0.667 0.667-0.367 0-0.666-0.298-0.666-0.667v-5.667c0-0.368 0.299-0.667 0.666-0.667 0.368 0 0.667 0.298 0.667 0.667v5.667zm3.08 0c0 0.368-0.299 0.667-0.667 0.667-0.367 0-0.666-0.298-0.666-0.667v-5.667c0-0.368 0.299-0.667 0.666-0.667 0.368 0 0.667 0.298 0.667 0.667v5.667z");
        }

        public void setPosition(double x, double y) {
            setTranslateX(x-250);
            setTranslateY(y-20);
        }

        public void updateStats() {
            updateStats.setText("Magazine: " + rifle.getMagazine() +
                                "\nRange: " + rifle.getRange() +
                                "\nAmmo: " + rifle.getAmmo() +
                                "\nBullet Damage: " + rifle.getBulletDamage() +
                                "\nScope: " + rifle.getScope());
        }
    }

    public static class Client2D extends Rectangle {

        private Client client;
        private Weapon2D weapon2D;
        private Text clientStats;

        Client2D(int x, int y, int w, int h, Color color, Client client) {
            super(w, h, color);
            this.client = client;
            this.clientStats = new Text();
            this.clientStats.setTranslateX(100);
            this.clientStats.setTranslateY(100);
            updateStats();
            setTranslateX(x);
            setTranslateY(y);
        }

        public Client getClient() {
            return client;
        }

        public Weapon2D getWeapon2D() {
            return weapon2D;
        }

        public Text getClientStats() {
            return clientStats;
        }

        void setWeapon(Weapon2D w) {
            w.setPosition(getTranslateX(), getTranslateY());
            this.weapon2D = w;
        }

        void updateStats() {
            clientStats.setText("Client\nweapons: " + client.getWeapons().size());
        }
    }

    public static class Dummy2D extends Rectangle {

        private Dummy dummy;
        private Text dummyStats;

        Dummy2D(int w, int h, Color color) {
            super(w, h, color);
            this.dummy = new Dummy(860, 100);
            this.dummyStats = new Text();
            this.dummyStats.setTranslateX(1000);
            this.dummyStats.setTranslateY(200);
            updateStats();
            this.setTranslateX(1000);
            this.setTranslateY(300);
        }

        public Dummy getDummy() {
            return dummy;
        }

        public Text getDummyStats() {
            return dummyStats;
        }

        void moveLeft() {
            if (dummy.getDistance() > 0) {
                setTranslateX(getTranslateX() - 10);
                dummy.setDistance(dummy.getDistance() - 10);
                dummyStats.setTranslateX(dummyStats.getTranslateX() - 10);
            }
        }

        void moveRight() {
            setTranslateX(getTranslateX() + 10);
            dummy.setDistance(dummy.getDistance() + 10);
            dummyStats.setTranslateX(dummyStats.getTranslateX() + 10);
        }

        void updateStats() {
            this.dummyStats.setText("Distance: " + dummy.getDistance() + "\nHP: " + dummy.getHp());
        }
    }

    public static class Bullet2D extends Rectangle {

        private final double dealDamage;
        private double range;

        Bullet2D(int x, int y, int w, int h, Color color, double dealDamage, double range) {
            super(w, h, color);
            this.dealDamage = dealDamage;
            this.range = range;
            setTranslateX(x);
            setTranslateY(y);
            setRotate(90);
        }

        public double getDealDamage() {
            return dealDamage;
        }
        public double getRange() {
            return range;
        }
        void moveRight() {
            setTranslateX(getTranslateX() + 8);
            this.range -= 8;
        }
    }

    public static class ThrowBall2D extends Circle {

        private final double dealDamage;
        private double range;
        private final double x0;
        private final double y0;
        private final double range0;

        ThrowBall2D(int x, int y, int r, Color color, double dealDamage, double range) {
            super(r, color);
            this.dealDamage = dealDamage;
            this.range = range;
            setTranslateX(x);
            setTranslateY(y);
            this.x0 = getTranslateX();
            this.y0 = getTranslateY();
            this.range0 = range;
            setRotate(90);
        }

        public double getDealDamage() {
            return dealDamage;
        }
        public double getRange() {
            return range;
        }
        void moveRight() {
            setTranslateX(getTranslateX() + 8);
            if (x0 <= getTranslateX() && getTranslateX() <= x0+range0) {
                double a = (range0/5)/(Math.pow(range0/2, 2));
                setTranslateY(y0 + a * (getTranslateX() - x0) * (getTranslateX() - (x0+range0)));
            }
            this.range -= 8;
        }
    }

}
