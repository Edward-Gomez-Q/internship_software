class CampusModel{
  final int idUniversity;
  final String nameUniversity;
  CampusModel({
    this.idUniversity = 0,
    this.nameUniversity = '',
  });
  CampusModel copyWith({
    int? idUniversity,
    String? nameUniversity,
  }) {
    return CampusModel(
      idUniversity: idUniversity ?? this.idUniversity,
      nameUniversity: nameUniversity ?? this.nameUniversity,
    );
  }
  Map<String, dynamic> toMap() {
    return {
      'idUniversity': idUniversity,
      'nameUniversity': nameUniversity,
    };
  }
  factory CampusModel.fromMap(Map<String, dynamic> map) {
    return CampusModel(
      idUniversity: map['idUniversity'],
      nameUniversity: map['nameUniversity'],
    );
  }

  static CampusModel fromJson(item) {
    return CampusModel(
      idUniversity: item['idUniversity'],
      nameUniversity: item['nameUniversity'],
    );
  }


}