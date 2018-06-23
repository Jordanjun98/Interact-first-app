package com.example.jordan.myapplication;


//Mars is the entire layout
public class Mars {

    private Page[] pages = new Page[7];

    public Mars() {

        pages[0] = new Page(R.string.page0,
                        R.drawable.page0,
                        new Choice(R.string.page0_choice1, 2),
                        new Choice(R.string.page0_choice2, 3));

        pages[1] = new Page(R.string.page1,
                            R.drawable.page1,
                            new Choice(R.string.page1_choice1, 3),
                            new Choice(R.string.page1_choice2,4));

        pages[2] = new Page(R.string.page2,
                            R.drawable.page2,
                            new Choice(R.string.page2_choice1,4),
                            new  Choice(R.string.page2_choice2,6));

        pages[3] = new Page(R.string.page3,
                            R.drawable.page3,
                            new Choice(R.string.page3_choice1,4),
                            new Choice(R.string.page3_choice2,5));

        pages[4] = new Page(R.string.page4,
                            R.drawable.page4,
                            new Choice(R.string.page4_choice1,5),
                            new Choice(R.string.page4_choice2,6));

        pages[5] = new Page(R.string.page5, R.drawable.page5);

        pages[6] = new Page(R.string.page5, R.drawable.page6);
    }

    public Page getPage(int i){

        return pages[i];


    }

}
