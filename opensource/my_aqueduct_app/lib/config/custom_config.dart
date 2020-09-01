
import 'package:my_aqueduct_app/my_aqueduct_app.dart';

/**
 * 自定义的configuration类
 */
class CustomConfig extends Configuration {
  CustomConfig(String path) : super.fromFile(File(path));

  DatabaseConfiguration database;//对应的数据库配置


}
