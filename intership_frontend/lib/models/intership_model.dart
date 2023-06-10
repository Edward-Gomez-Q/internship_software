class IntershipModel {
  final String titleIntership;
  final String department;
  final DateTime deadline;
  final int days;
  final int durations;
  final DateTime startTime;
  final DateTime endTime;
  final String description;
  final String urlPDF;
  final String urlWord;
  final String requirements;
  final List<String> careers;
  final List<String> knowledge;

  IntershipModel({
    this.titleIntership = '',
    this.department = '',
    DateTime? deadline,
    this.days = 0,
    this.durations = 0,
    DateTime? startTime,
    DateTime? endTime,
    this.description = '',
    this.urlPDF = '',
    this.urlWord = '',
    this.requirements = '',
    this.careers = const [],
    this.knowledge = const [],
  })  : this.deadline = deadline ?? DateTime.now(),
        this.startTime = startTime ?? DateTime.now(),
        this.endTime = endTime ?? DateTime.now();
  IntershipModel copyWith({
    String? titleIntership,
    String? department,
    DateTime? deadline,
    int? days,
    int? durations,
    DateTime? startTime,
    DateTime? endTime,
    String? description,
    String? urlPDF,
    String? urlWord,
    String? requirements,
    List<String>? careers,
    List<String>? knowledge,
  }) {
    return IntershipModel(
      titleIntership: titleIntership ?? this.titleIntership,
      department: department ?? this.department,
      deadline: deadline ?? this.deadline,
      days: days ?? this.days,
      durations: durations ?? this.durations,
      startTime: startTime ?? this.startTime,
      endTime: endTime ?? this.endTime,
      description: description ?? this.description,
      urlPDF: urlPDF ?? this.urlPDF,
      urlWord: urlWord ?? this.urlWord,
      requirements: requirements ?? this.requirements,
      careers: careers ?? this.careers,
      knowledge: knowledge ?? this.knowledge,
    );
  }

  @override
  List<Object?> get props => [
        titleIntership,
        department,
        deadline,
        days,
        durations,
        startTime,
        endTime,
        description,
        urlPDF,
        urlWord,
        requirements,
        careers,
        knowledge,
      ];
}
