public class SearchWord {
    public static long[] search(Matrix m, String keyword){
        String[] keyArr = keyword.split("");
        String first = keyArr[0];
        boolean found = false;
        int i = 0;
        int j = 0;
        int count = 0;
        long time = 0;
        long tempStart = System.currentTimeMillis();
        
        while (i < m.rows && !found){
            while (j < m.cols && !found){
                count++;
                if (first.equals(m.buffer[i][j].oriChar)){
                    Exec temp = Matcher.checkHL(m, keyArr, i, j);
                    if (!found){
                        count += temp.count;
                        if (temp.flag){
                            time = System.currentTimeMillis() - tempStart;
                            System.out.println("Keyword \'" + keyword + "\' found horizontally left!");
                            System.out.println("Comparison: " + count + " time(s) | " + time + " ms");
                            found = true;
                        }
                    }

                    temp = Matcher.checkDLL(m, keyArr, i, j);
                    if (!found){
                        count += temp.count;
                        if (temp.flag){
                            time = System.currentTimeMillis() - tempStart;
                            System.out.println("Keyword \'" + keyword + "\' found diagonally! (left lower)");
                            System.out.println("Comparison: " + count + " time(s) | " + time + " ms");
                            found = true;
                        }
                    }

                    temp = Matcher.checkVL(m, keyArr, i, j);
                    if (!found){
                        count += temp.count;
                        if (temp.flag){
                            time = System.currentTimeMillis() - tempStart;
                            System.out.println("Keyword \'" + keyword + "\' found vertically lower!");
                            System.out.println("Comparison: " + count + " time(s) | " + time + " ms");
                            found = true;
                        }
                    }
                    
                    temp = Matcher.checkDRL(m, keyArr, i, j);
                    if (!found){
                        count += temp.count;
                        if (temp.flag){
                            time = System.currentTimeMillis() - tempStart;
                            System.out.println("Keyword \'" + keyword + "\' found diagonally! (right lower)");
                            System.out.println("Comparison: " + count + " time(s) | " + time + " ms");
                            found = true;
                        } 
                    }
                    
                    temp = Matcher.checkHR(m, keyArr, i, j);
                    if (!found){
                        count += temp.count;
                        if (temp.flag){
                            time = System.currentTimeMillis() - tempStart;
                            System.out.println("Keyword \'" + keyword + "\' found horizontally right!");
                            System.out.println("Comparison: " + count + " time(s) | " + time + " ms");
                            found = true;
                        }
                    }

                    temp = Matcher.checkDRU(m, keyArr, i, j);
                    if (!found){
                        count += temp.count;
                        if (temp.flag && !found){
                            time = System.currentTimeMillis() - tempStart;
                            System.out.println("Keyword \'" + keyword + "\' found diagonally! (right upper)");
                            System.out.println("Comparison: " + count + " time(s) | " + time + " ms");
                            found = true;
                        } 
                    }  
                    temp = Matcher.checkVU(m, keyArr, i, j);
                    if (!found){
                        count += temp.count;
                        if (temp.flag ){
                            time = System.currentTimeMillis() - tempStart;
                            System.out.println("Keyword \'" + keyword + "\' found vertically upper!");
                            System.out.println("Comparison: " + count + " time(s) | " + time + " ms");
                            found = true;
                        } 
                    }
                    
                    temp = Matcher.checkDLU(m, keyArr, i, j);
                    if (!found){
                        count += temp.count;
                        if (temp.flag){
                            time = System.currentTimeMillis() - tempStart;
                            System.out.println("Keyword \'" + keyword + "\' found diagonally! (left upper)");
                            System.out.println("Comparison: " + count + " time(s) | " + time + " ms");
                            found = true;
                        } 
                    }
                }
                j = j + 1;
            }
            j = 0;
            i = i + 1;
        }
        if (!found){
            time = System.currentTimeMillis() - tempStart;
            System.out.println("Keyword \'" + keyword + "\' not found...");
            System.out.println("Comparison: " + count + " time(s) | " + time + " ms");
        }
        System.out.println(); 
        long[] arr = {time, Long.valueOf(count)};
        return arr;
    }
}
