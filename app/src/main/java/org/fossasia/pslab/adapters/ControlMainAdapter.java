package org.fossasia.pslab.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.fossasia.pslab.R;
import org.fossasia.pslab.communication.ScienceLab;
import org.fossasia.pslab.others.ScienceLabCommon;

/**
 * Created by asitava on 6/6/17.
 */

public class ControlMainAdapter extends RecyclerView.Adapter<ControlMainAdapter.ViewHolder> {

    private String[] mDataset;
    private ScienceLab scienceLab = ScienceLabCommon.scienceLab;

    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView mCardView;
        TextView tvControlMain1;
        TextView tvControlMain2;
        EditText editTextControlMain;
        Button buttonControlMain1;
        Button buttonControlMain2;
        Button buttonControlMain3;
        SeekBar seekBarControlMain;

        public ViewHolder(View view) {
            super(view);
            mCardView = (CardView) view.findViewById(R.id.cardview_control_main);
            tvControlMain1 = (TextView) view.findViewById(R.id.tv_control_main1);
            tvControlMain2 = (TextView) view.findViewById(R.id.tv_control_main2);
            editTextControlMain = (EditText) view.findViewById(R.id.edittext_control_main);
            buttonControlMain1 = (Button) view.findViewById(R.id.button_control_main1);
            buttonControlMain2 = (Button) view.findViewById(R.id.button_control_main2);
            buttonControlMain3 = (Button) view.findViewById(R.id.button_control_main3);
            seekBarControlMain = (SeekBar) view.findViewById(R.id.seekbar_control_main);
            editTextControlMain.setText("0");
        }

    }

    public ControlMainAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ControlMainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.control_main_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.setIsRecyclable(true);
        holder.tvControlMain1.setText(mDataset[position]);

        final Button buttonControlMain1 = holder.buttonControlMain1;
        final Button buttonControlMain2 = holder.buttonControlMain2;
        Button buttonControlMain3 = holder.buttonControlMain3;

        final SeekBar seekBarControlMain = holder.seekBarControlMain;
        final EditText editTextControlMain = holder.editTextControlMain;

        switch (position) {
            case 0:
                buttonControlMain1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Double data = Double.valueOf(editTextControlMain.getText().toString());
                        Double dataDecrement = data - 0.0025;
                        if (dataDecrement < -5.0)
                            dataDecrement = -5.0;
                        else if (dataDecrement > 5.0)
                            dataDecrement = 5.0;
                        seekBarControlMain.setProgress((int) ((dataDecrement + 5) * 10));
                        editTextControlMain.setText(String.valueOf(dataDecrement));
                    }
                });

                buttonControlMain2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Double data1 = Double.valueOf(editTextControlMain.getText().toString());
                        Double dataIncrement = data1 + 0.0025;
                        if (dataIncrement < -5.0)
                            dataIncrement = -5.0;
                        else if (dataIncrement > 5.0)
                            dataIncrement = 5.0;
                        seekBarControlMain.setProgress((int) ((dataIncrement + 5) * 10));
                        editTextControlMain.setText(String.valueOf(dataIncrement));
                    }
                });

                buttonControlMain3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Float value = Float.parseFloat(editTextControlMain.getText().toString());
                        if (value > 5)
                            value = 5f;
                        else if (value < -5)
                            value = -5f;
                        editTextControlMain.setText(String.valueOf(value));
                        //seekBarControlMain.setProgress((int) ((value + 5) * 10));

                        if (scienceLab.isConnected())
                            scienceLab.setPV1(value);
                    }
                });

                seekBarControlMain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        double text = progress / 10.0 - 5.0;
                        editTextControlMain.setText(String.valueOf(text));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                break;
            case 1:
                buttonControlMain1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Double data = Double.valueOf(editTextControlMain.getText().toString());
                        Double dataDecrement = data - 0.0025;
                        if (dataDecrement < -3.3)
                            dataDecrement = -3.3;
                        else if (dataDecrement > 3.3)
                            dataDecrement = 3.3;
                        seekBarControlMain.setProgress((int) ((dataDecrement + 3.3) * 15.15));
                        editTextControlMain.setText(String.valueOf(dataDecrement));
                    }
                });

                buttonControlMain2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Double data1 = Double.valueOf(editTextControlMain.getText().toString());
                        Double dataIncrement = data1 + 0.0025;
                        if (dataIncrement < -3.3)
                            dataIncrement = -3.3;
                        else if (dataIncrement > 3.3)
                            dataIncrement = 3.3;
                        seekBarControlMain.setProgress((int) ((dataIncrement + 3.3) * 15.15));
                        editTextControlMain.setText(String.valueOf(dataIncrement));
                    }
                });

                buttonControlMain3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Float value = Float.parseFloat(editTextControlMain.getText().toString());
                        if (value > 3.3)
                            value = 3.3f;
                        else if (value < -3.3)
                            value = -3.3f;
                        editTextControlMain.setText(String.valueOf(value));
                        //seekBarControlMain.setProgress((int) ((value + 3.3) * 15.15));

                        if (scienceLab.isConnected())
                            scienceLab.setPV2(value);
                    }
                });

                seekBarControlMain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        double text = progress / 15.15 - 3.3;
                        editTextControlMain.setText(String.valueOf(text));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                break;


            case 2:
                buttonControlMain1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Double data = Double.valueOf(editTextControlMain.getText().toString());
                        Double dataDecrement = data - 0.0025;
                        if (dataDecrement < 0.0)
                            dataDecrement = 0.0;
                        else if (dataDecrement > 3.3)
                            dataDecrement = 3.3;
                        seekBarControlMain.setProgress((int) (dataDecrement * 30.30));
                        editTextControlMain.setText(String.valueOf(dataDecrement));
                    }
                });

                buttonControlMain2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Double data1 = Double.valueOf(editTextControlMain.getText().toString());
                        Double dataIncrement = data1 + 0.0025;
                        if (dataIncrement < 0.0)
                            dataIncrement = 0.0;
                        else if (dataIncrement > 3.3)
                            dataIncrement = 3.3;
                        seekBarControlMain.setProgress((int) (dataIncrement * 30.30));
                        editTextControlMain.setText(String.valueOf(dataIncrement));
                    }
                });

                buttonControlMain3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Float value = Float.parseFloat(editTextControlMain.getText().toString());
                        if (value > 3.3)
                            value = 3.3f;
                        else if (value < 0)
                            value = 0f;
                        editTextControlMain.setText(String.valueOf(value));
                        //seekBarControlMain.setProgress((int) (value * 30.30));

                        if (scienceLab.isConnected())
                            scienceLab.setPV3(value);
                    }
                });

                seekBarControlMain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        double text = progress / 30.30;
                        editTextControlMain.setText(String.valueOf(text));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                break;

            case 3:
                buttonControlMain1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Double data = Double.valueOf(editTextControlMain.getText().toString());
                        Double dataDecrement = data - 0.0025;
                        if (dataDecrement < 0.0)
                            dataDecrement = 0.0;
                        else if (dataDecrement > 3.3)
                            dataDecrement = 3.3;
                        seekBarControlMain.setProgress((int) (dataDecrement * 30.30));
                        editTextControlMain.setText(String.valueOf(dataDecrement));
                    }
                });

                buttonControlMain2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Double data1 = Double.valueOf(editTextControlMain.getText().toString());
                        Double dataIncrement = data1 + 0.0025;
                        if (dataIncrement < 0.0)
                            dataIncrement = 0.0;
                        else if (dataIncrement > 3.3)
                            dataIncrement = 3.3;
                        seekBarControlMain.setProgress((int) (dataIncrement * 30.30));
                        editTextControlMain.setText(String.valueOf(dataIncrement));
                    }
                });

                buttonControlMain3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Float value = Float.parseFloat(editTextControlMain.getText().toString());
                        if (value > 3.3)
                            value = 3.3f;
                        else if (value < 0)
                            value = 0f;
                        editTextControlMain.setText(String.valueOf(value));
                        //seekBarControlMain.setProgress((int) (value * 30.30));

                        if (scienceLab.isConnected())
                            scienceLab.setPCS(value);

                    }
                });

                seekBarControlMain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        double text = progress / 30.30;
                        editTextControlMain.setText(String.valueOf(text));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                break;

            case 4:
                buttonControlMain1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int data = Integer.valueOf(editTextControlMain.getText().toString());
                        int dataDecrement = data - 1;
                        if (dataDecrement < 10)
                            dataDecrement = 10;
                        else if (dataDecrement > 5000)
                            dataDecrement = 5000;

                        seekBarControlMain.setProgress((int) ((dataDecrement - 10) / 49.9));
                        editTextControlMain.setText(String.valueOf(dataDecrement));
                    }
                });

                buttonControlMain2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int data1 = Integer.valueOf(editTextControlMain.getText().toString());
                        int dataIncrement = data1 + 1;
                        if (dataIncrement < 10)
                            dataIncrement = 10;
                        else if (dataIncrement > 5000)
                            dataIncrement = 5000;
                        seekBarControlMain.setProgress((int) ((dataIncrement - 10) / 49.9));
                        editTextControlMain.setText(String.valueOf(dataIncrement));
                    }
                });

                buttonControlMain3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Float value = Float.parseFloat(editTextControlMain.getText().toString());
                        if (value < 10)
                            value = 10f;
                        else if (value > 5000)
                            value = 5000f;
                        editTextControlMain.setText(String.valueOf(value));
                        //seekBarControlMain.setProgress((int) ((value - 10) / 49.9));

                        // call to scienceLab for setting
                    }
                });

                seekBarControlMain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int text = (int) (progress * 49.9 + 10);
                        editTextControlMain.setText(String.valueOf(text));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                break;
            case 5:
                buttonControlMain1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int data = Integer.valueOf(editTextControlMain.getText().toString());
                        int dataDecrement = data - 1;
                        if (dataDecrement < 10)
                            dataDecrement = 10;
                        else if (dataDecrement > 5000)
                            dataDecrement = 5000;
                        seekBarControlMain.setProgress((int) ((dataDecrement - 10) / 49.9));
                        editTextControlMain.setText(String.valueOf(dataDecrement));
                    }
                });

                buttonControlMain2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int data1 = Integer.valueOf(editTextControlMain.getText().toString());
                        int dataIncrement = data1 + 1;
                        if (dataIncrement < 10)
                            dataIncrement = 10;
                        else if (dataIncrement > 5000)
                            dataIncrement = 5000;
                        seekBarControlMain.setProgress((int) ((dataIncrement - 10) / 49.9));
                        editTextControlMain.setText(String.valueOf(dataIncrement));
                    }
                });

                buttonControlMain3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Float value = Float.parseFloat(editTextControlMain.getText().toString());
                        if (value < 10)
                            value = 10f;
                        else if (value > 5000)
                            value = 5000f;
                        editTextControlMain.setText(String.valueOf(value));
                        //seekBarControlMain.setProgress((int) ((value - 10) / 49.9));

                        // call to scienceLab for setting
                    }
                });
                seekBarControlMain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int text = (int) (progress * 49.9 + 10);
                        editTextControlMain.setText(String.valueOf(text));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                break;

            case 6:
                buttonControlMain1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int data = Integer.valueOf(editTextControlMain.getText().toString());
                        int dataDecrement = data - 1;
                        if (dataDecrement < 10)
                            dataDecrement = 10;
                        else if (dataDecrement > 5000)
                            dataDecrement = 5000;
                        seekBarControlMain.setProgress((int) ((dataDecrement - 10) / 49.9));
                        editTextControlMain.setText(String.valueOf(dataDecrement));
                    }
                });

                buttonControlMain2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int data1 = Integer.valueOf(editTextControlMain.getText().toString());
                        int dataIncrement = data1 + 1;
                        if (dataIncrement < 10)
                            dataIncrement = 10;
                        else if (dataIncrement > 5000)
                            dataIncrement = 5000;
                        seekBarControlMain.setProgress((int) ((dataIncrement - 10) / 49.9));
                        editTextControlMain.setText(String.valueOf(dataIncrement));
                    }
                });

                buttonControlMain3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Float value = Float.parseFloat(editTextControlMain.getText().toString());
                        if (value < 10)
                            value = 10f;
                        else if (value > 5000)
                            value = 5000f;
                        editTextControlMain.setText(String.valueOf(value));
                        //seekBarControlMain.setProgress((int) ((value - 10) / 49.9));

                        // call to scienceLab for setting
                    }
                });
                seekBarControlMain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int text = (int) (progress * 49.9 + 10);
                        editTextControlMain.setText(String.valueOf(text));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}