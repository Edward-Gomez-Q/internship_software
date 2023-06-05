class CareerModel{
  final int idCareer;
  final String nameCareer;
  CareerModel({
    this.idCareer = 0,
    this.nameCareer = '',
  });
  CareerModel copyWith({
    int? idCareer,
    String? nameCareer,
  }) {
    return CareerModel(
      idCareer: idCareer ?? this.idCareer,
      nameCareer: nameCareer ?? this.nameCareer,
    );
  }
  Map<String, dynamic> toMap() {
    return {
      'idCareer': idCareer,
      'nameCareer': nameCareer,
    };
  }
  factory CareerModel.fromMap(Map<String, dynamic> map) {
    return CareerModel(
      idCareer: map['idCareer'],
      nameCareer: map['nameCareer'],
    );
  }
  static CareerModel fromJson(item) {
    return CareerModel(
      idCareer: item['idCareer'],
      nameCareer: item['nameCareer'],
    );
  }

}