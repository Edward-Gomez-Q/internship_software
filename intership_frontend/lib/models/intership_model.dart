class IntershipModel {
  final String titleIntership;
  final String department;
  final DateTime deadline;
  final List<String> days;
  final int durations;
  final DateTime startTime;
  final DateTime endTime;
  final String urlPDF;
  final String urlWord;
  final String requirements;
  final List<String> careers;
  final bool status;
  final List<String> knowledge;

  IntershipModel({
    this.titleIntership = '',
    this.department = '',
    DateTime? deadline,
    this.days = const [],
    this.durations = 0,
    DateTime? startTime,
    DateTime? endTime,
    this.urlPDF = '',
    this.urlWord = '',
    this.requirements = '',
    this.careers = const [],
    this.status = true,
    this.knowledge = const [],
  })  : this.deadline = deadline ?? DateTime.now(),
        this.startTime = startTime ?? DateTime.now(),
        this.endTime = endTime ?? DateTime.now();

  IntershipModel copyWith({
    String? titleIntership,
    String? department,
    DateTime? deadline,
    List<String>? days,
    int? durations,
    DateTime? startTime,
    DateTime? endTime,
    String? description,
    String? urlPDF,
    String? urlWord,
    String? requirements,
    List<String>? careers,
    bool? status,
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
      urlPDF: urlPDF ?? this.urlPDF,
      urlWord: urlWord ?? this.urlWord,
      requirements: requirements ?? this.requirements,
      careers: careers ?? this.careers,
      status: status ?? this.status,
      knowledge: knowledge ?? this.knowledge,
    );
  }

  Map<String, dynamic> toMap() {
    return {
      'titleIntership': titleIntership,
      'department': department,
      'deadline': deadline,
      'days': days,
      'durations': durations,
      'startTime': startTime,
      'endTime': endTime,
      'urlPDF': urlPDF,
      'urlWord': urlWord,
      'requirements': requirements,
      'careers': careers,
      'status': status,
      'knowledge': knowledge,
    };
  }

  factory IntershipModel.fromMap(Map<String, dynamic> map) {
    return IntershipModel(
      titleIntership: map['titleIntership'],
      department: map['department'],
      deadline: map['deadline'],
      days: List<String>.from(map['days']),
      durations: map['durations'],
      startTime: map['startTime'],
      endTime: map['endTime'],
      urlPDF: map['urlPDF'],
      urlWord: map['urlWord'],
      requirements: map['requirements'],
      careers: List<String>.from(map['careers']),
      status: map['status'],
      knowledge: List<String>.from(map['knowledge']),
    );
  }
  static IntershipModel fromJson(item) {
    return IntershipModel(
      titleIntership: item['titleIntership'],
      department: item['department'],
      deadline: item['deadline'],
      days: List<String>.from(item['days']),
      durations: item['durations'],
      startTime: item['startTime'],
      endTime: item['endTime'],
      urlPDF: item['urlPDF'],
      urlWord: item['urlWord'],
      requirements: item['requirements'],
      careers: List<String>.from(item['careers']),
      status: item['status'],
      knowledge: List<String>.from(item['knowledge']),
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
        urlPDF,
        urlWord,
        requirements,
        careers,
        status,
        knowledge,
      ];
}
