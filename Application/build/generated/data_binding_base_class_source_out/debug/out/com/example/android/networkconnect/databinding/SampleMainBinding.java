// Generated by view binder compiler. Do not edit!
package com.example.android.networkconnect.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.android.networkconnect.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SampleMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView dataText;

  @NonNull
  public final TextView introText;

  private SampleMainBinding(@NonNull LinearLayout rootView, @NonNull TextView dataText,
      @NonNull TextView introText) {
    this.rootView = rootView;
    this.dataText = dataText;
    this.introText = introText;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SampleMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SampleMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.sample_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SampleMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.data_text;
      TextView dataText = ViewBindings.findChildViewById(rootView, id);
      if (dataText == null) {
        break missingId;
      }

      id = R.id.intro_text;
      TextView introText = ViewBindings.findChildViewById(rootView, id);
      if (introText == null) {
        break missingId;
      }

      return new SampleMainBinding((LinearLayout) rootView, dataText, introText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
