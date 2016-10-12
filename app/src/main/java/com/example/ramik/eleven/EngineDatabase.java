package com.example.ramik.eleven;

import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rami on 2/28/2016.
 */
public class EngineDatabase {

    public List<NumberChooser> engines = new ArrayList<>();
    private int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    public EngineDatabase(final Button mElevenButton){
        //level one engine: basic: speed = 1s
        engines.add(new NumberChooser(new DelayProvider() {
                @Override
                public int getNextDelay() {return 500;
                }
            }, new NumberProvider() {
                int index = 0;
                boolean indexIsIncreasing = true;
                @Override
                public int getNextNumber() {
                    index = updateIndex(index, indexIsIncreasing);
                    indexIsIncreasing = checkIfIncreasing(numbers[index], indexIsIncreasing, 20, 0);
                    return numbers[index];
                }
            }, mElevenButton));
        //level two engine: basic: speed = 0.9s
        engines.add(new NumberChooser(new DelayProvider() {
            @Override
            public int getNextDelay() {
                return 400;
            }
        }, new NumberProvider() {
            int index = 0;
            boolean indexIsIncreasing = true;
            @Override
            public int getNextNumber() {
                index = updateIndex(index, indexIsIncreasing);
                indexIsIncreasing = checkIfIncreasing(numbers[index], indexIsIncreasing, 20, 0);
                return numbers[index];
            }
        }, mElevenButton));
        //level three engine: basic: speed = 0.75s
        engines.add(new NumberChooser(new DelayProvider() {
            @Override
            public int getNextDelay() {
                return 350;
            }
        }, new NumberProvider() {
            int index = 0;
            boolean indexIsIncreasing = true;
            @Override
            public int getNextNumber() {
                index = updateIndex(index, indexIsIncreasing);
                indexIsIncreasing = checkIfIncreasing(numbers[index], indexIsIncreasing, 20, 0);
                return numbers[index];
            }
        }, mElevenButton));
        //level four engine: basic: speed = 0.65s
        engines.add(new NumberChooser(new DelayProvider() {
            @Override
            public int getNextDelay() {
                return 300;
            }
        }, new NumberProvider() {
            int index = 0;
            boolean indexIsIncreasing = true;
            @Override
            public int getNextNumber() {
                index = updateIndex(index, indexIsIncreasing);
                indexIsIncreasing = checkIfIncreasing(numbers[index], indexIsIncreasing, 20, 0);
                return numbers[index];
            }
        }, mElevenButton));
        //level five engine: basic: speed = .25s
        engines.add(new NumberChooser(new DelayProvider() {
            @Override
            public int getNextDelay() {
                return 250;
            }
        }, new NumberProvider() {
            int index = 0;
            boolean indexIsIncreasing = true;
            @Override
            public int getNextNumber() {
                index = updateIndex(index, indexIsIncreasing);
                indexIsIncreasing = checkIfIncreasing(numbers[index], indexIsIncreasing, 20, 0);
                return numbers[index];
            }
        }, mElevenButton));
        //level six engine: basic: speed = 0.5s
        engines.add(new NumberChooser(new DelayProvider() {
            @Override
            public int getNextDelay() {
                return 200;
            }
        }, new NumberProvider() {
            int index = 0;
            boolean indexIsIncreasing = true;
            @Override
            public int getNextNumber() {
                index = updateIndex(index, indexIsIncreasing);
                indexIsIncreasing = checkIfIncreasing(numbers[index], indexIsIncreasing, 20, 0);
                return numbers[index];
            }
        }, mElevenButton));
        //level seven engine: basic: speed = 0.4s
        engines.add(new NumberChooser(new DelayProvider() {
            @Override
            public int getNextDelay() {
                return 175;
            }
        }, new NumberProvider() {
            int index = 0;
            boolean indexIsIncreasing = true;
            @Override
            public int getNextNumber() {
                index = updateIndex(index, indexIsIncreasing);
                indexIsIncreasing = checkIfIncreasing(numbers[index], indexIsIncreasing, 20, 0);
                return numbers[index];
            }
        }, mElevenButton));
        //level eight engine: basic: speed = 0.3s
        engines.add(new NumberChooser(new DelayProvider() {
            @Override
            public int getNextDelay() {
                return 150;
            }
        }, new NumberProvider() {
            int index = 0;
            boolean indexIsIncreasing = true;
            @Override
            public int getNextNumber() {
                index = updateIndex(index, indexIsIncreasing);
                indexIsIncreasing = checkIfIncreasing(numbers[index], indexIsIncreasing, 20, 0);
                return numbers[index];
            }
        }, mElevenButton));
        //level nine engine: basic: speed = 0.2s
        engines.add(new NumberChooser(new DelayProvider() {
            @Override
            public int getNextDelay() {
                return 125;
            }
        }, new NumberProvider() {
            int index = 0;
            boolean indexIsIncreasing = true;
            @Override
            public int getNextNumber() {
                index = updateIndex(index, indexIsIncreasing);
                indexIsIncreasing = checkIfIncreasing(numbers[index], indexIsIncreasing, 20, 0);
                return numbers[index];
            }
        }, mElevenButton));
        //level ten engine: speeds up as it gets towards higher/lower numbers
        engines.add(new NumberChooser(new DelayProvider() {
            String[] higherNumbers = {"15", "16", "17", "18", "19", "20"};
            String[] lowerNumbers = {"5", "4", "3", "2", "1", "0"};
            int[] delayTimes = {100, 90, 80, 70, 60, 50};
            @Override
            public int getNextDelay() {
                for (int i = 0; i < higherNumbers.length; i++){
                    if (mElevenButton.getText().toString().equals(higherNumbers[i]) || mElevenButton.getText().toString().equals(lowerNumbers[i])){
                        return delayTimes[i];
                    }
                }
                return 110;
            }
        }, new NumberProvider() {
            int index = 0;
            boolean indexIsIncreasing = true;
            @Override
            public int getNextNumber() {
                index = updateIndex(index, indexIsIncreasing);
                indexIsIncreasing = checkIfIncreasing(numbers[index], indexIsIncreasing, 20, 0);
                return numbers[index];
            }
        }, mElevenButton));
        //level eleven engine: speeds up as it nears 11
        engines.add(new NumberChooser(new DelayProvider() {
            int delay = 120;
            String[] middleNumbers = {"6", "7", "8", "9", "10", "11", "12", "13", "14"};
            int[] delayTimes = {110, 100, 90, 80, 70, 80, 90, 100, 110};
            @Override
            public int getNextDelay() {
                for (int i = 0; i < middleNumbers.length; i++){
                    if (mElevenButton.getText().toString().equals(middleNumbers[i])){
                        return delayTimes[i];
                    }
                }
                return delay;
            }
        }, new NumberProvider() {
            int index = 0;
            boolean indexIsIncreasing = true;
            @Override
            public int getNextNumber() {
                index = updateIndex(index, indexIsIncreasing);
                indexIsIncreasing = checkIfIncreasing(numbers[index], indexIsIncreasing, 20, 0);
                return numbers[index];
            }
        }, mElevenButton));
        //level twelve engine: only odd numbers
        engines.add(new NumberChooser(new DelayProvider() {
            @Override
            public int getNextDelay() {
                return 120;
            }
        }, new NumberProvider() {
            int index = 1;
            boolean isIndexIncreasing = true;
            @Override
            public int getNextNumber() {
                index = updateIndex(index, isIndexIncreasing);
                index = updateIndex(index, isIndexIncreasing);
                isIndexIncreasing = checkIfIncreasing(numbers[index], isIndexIncreasing, 19, 1);
                return numbers[index];
            }
        }, mElevenButton));

        engines.add(new NumberChooser(new DelayProvider() {
            @Override
            public int getNextDelay() {
                return 110;
            }
        }, new NumberProvider() {
            @Override
            public int getNextNumber() {
                return 0;
            }
        }, mElevenButton));
    }

    private int updateIndex(int index, boolean indexIsIncreasing){
        if (indexIsIncreasing) {
            index++;
        } else {
            index--;
        }
        return index;
    }

    private boolean checkIfIncreasing(int number, boolean indexIsIncreasing, int max, int min){
        if (number == max) {
            indexIsIncreasing = false;
        }
        if (number == min && !indexIsIncreasing) {
            indexIsIncreasing = true;
        }

        return indexIsIncreasing;
    }

    public List<NumberChooser> getEngines(){
        return engines;
    }

    public NumberChooser getEngine(int level){
        return engines.get(level);
    }

}
