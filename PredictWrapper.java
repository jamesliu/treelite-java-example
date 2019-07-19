import treelite.predictor.*;

public class PredictWrapper {

  // value[i] contains a floating-point value or NaN (Not A Number).
  // value[i]=NaN indicates that feature i is missing
  public static float predict(float[] value) {
    final int num_feature = Main.get_num_feature();
    assert num_feature == value.length;
    Entry[] data = new Entry[num_feature];
    for (int i = 0; i < num_feature; ++i) {
      data[i] = new Entry();
      if (Float.isNaN(value[i])) {
        data[i].missing.set(-1);
      } else {
        data[i].fvalue.set(value[i]);
      }
    }
    return Main.predict_margin(data);
  }

  /*
  public static void main(String[] args) {
    final int num_feature = Main.get_num_feature();
    float[] x = new float[num_feature];
    for (int i=0; i < x.length; i++) {
      x[i] = (float)(1.0/(i + 1));
    }
    float score = PredictWrapper.predict(x);
    System.out.println("score:" + score);
  }*/
}
