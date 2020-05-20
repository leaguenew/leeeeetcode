package leetcode;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Base {

    public void testSFCInfo() {

        class VO {
            int a;
            int b;

            public VO(int a, int b) {
                this.a = a;
                this.b = b;
            }

            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }

            public int getB() {
                return b;
            }

            public void setB(int b) {
                this.b = b;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null)
                    return false;
                if (this == obj)
                    return true;
                if (obj instanceof VO) {
                    VO vo = (VO) obj;

                    // 比较每个属性的值 一致时才返回true
                    if (vo.a == this.a && vo.b == (this.b))
                        return true;
                }
                return false;
            }

            /**
             * 重写hashcode 方法，返回的hashCode不一样才再去比较每个属性的值
             */
            @Override
            public int hashCode() {
                return a * b;
            }

        }

        File inputFile = new File("/Users/niuliguo/data/passenger_info/sfc.txt");
        File outputFile = new File("/Users/niuliguo/data/passenger_info/sfc_result.txt");

        if (!outputFile.exists()) {
            try {
                outputFile.createNewFile();
                System.out.println("create file success.");
            } catch (IOException e) {
                System.out.println("create file error.");
            }
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileOutputStream outFile = new FileOutputStream(outputFile, false);
            String s = null;
            int cnt = 0;
            Map<VO, Integer> map = new HashMap<VO, Integer>();
            while((s = br.readLine())!=null) {
                cnt++;

//                if (cnt > 10) {
//                    break;
//                }

                String[] strArr = s.split("\\s+");
                int a = Integer.parseInt(strArr[0]);
                int b = Integer.parseInt(strArr[1]);
                int c = Integer.parseInt(strArr[2]);
                VO vo = new VO(a, b);
                if (map.containsKey(vo)) {
                    map.put(vo, map.get(vo).intValue() + c);
                } else {
                    map.put(vo, c);
                }
            }
            for(Map.Entry<VO, Integer> item: map.entrySet()) {
                outFile.write((item.getKey().getA() + "\t" + item.getKey().getB() + "\t" + item.getValue() +"\n").getBytes());
            }

            outFile.close();
            System.out.println("tasks: " + (cnt - 1) + " finished...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public void testDriverInfoHashing() {
        File inputFile = new File("/Users/niuliguo/data/punish/20910520/dri_T3.1_block_251212");

        int tableLength = 64;
        int[] count1 = new int[tableLength];
        int[] count2 = new int[tableLength];

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String s = null;
            int cnt = 0;
            while((s = br.readLine())!=null) {
                cnt++;

                String[] strArr = s.split("\\|");

                Long driverId = Long.parseLong(strArr[0].trim());
                int idx1 = Math.abs(driverId.intValue() % tableLength);
                int idx2 = Math.abs(driverId.hashCode() % tableLength);
                count1[idx1] += 1;
                count2[idx2] += 1;
            }
            System.out.println("tasks: " + (cnt - 1) + " finished...");

            int avg = cnt / count1.length;
            System.out.println("avg = " + avg);
            int variance1 = 0 , variance2 = 0;
            for(int i = 0; i < tableLength; i++) {
                System.out.print(count1[i] + " ");
                variance1 += (count1[i] - avg) * (count1[i] - avg);
            }
            System.out.println();
            for(int i = 0; i < tableLength; i++) {
                System.out.print(count2[i] + " ");
                variance2 += (count2[i] - avg) * (count2[i] - avg);
            }
            System.out.println();
            System.out.println("variance1 = " + variance1/cnt);
            System.out.println("variance2 = " + variance2/cnt);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
