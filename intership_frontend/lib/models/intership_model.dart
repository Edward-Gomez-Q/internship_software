import 'package:equatable/equatable.dart';

class IntershipModel extends Equatable{
  final String title;
  final String department;
  final DateTime deadline;
  final String days;
  final int duration;
  final DateTime startDate;
  final DateTime endDate;
  final String description;
  final String urlPDF;
  final String urlWord;
  final List<String> careers;
  final String knowledge;
  IntershipModel({
    required this.title,
    required this.department,
    required this.deadline,
    required this.days,
    required this.duration,
    required this.startDate,
    required this.endDate,
    required this.description,
    required this.urlPDF,
    required this.urlWord,
    required this.careers,
    required this.knowledge,
  });
  factory IntershipModel.fromJson(Map<String, dynamic> json) {
    return IntershipModel(
      title: json['titleIntership'],
      department: json['department'],
      deadline: DateTime.parse(json['deadline']),
      days: json['days'],
      duration: json['durations'],
      startDate: DateTime.parse(json['startTime']),
      endDate: DateTime.parse(json['endTime']),
      description: json['requirements'],
      urlPDF: json['urlPDF'],
      urlWord: json['urlWord'],
      careers: json['careers'].cast<String>(),
      knowledge: json['knowledge'],
    );
  }
  Map<String, dynamic> toJson() {
    return {
      'titleIntership': title,
      'department': department,
      'deadline': deadline.toString(),
      'days': days,
      'durations': duration,
      'startTime': startDate.toString(),
      'endTime': endDate.toString(),
      'requirements': description,
      'urlPDF': urlPDF,
      'urlWord': urlWord,
      'careers': careers,
      'knowledge': knowledge,
    };
  }
  IntershipModel copyWith({
    String? title,
    String? department,
    DateTime? deadline,
    String? days,
    int? duration,
    DateTime? startDate,
    DateTime? endDate,
    String? description,
    String? urlPDF,
    String? urlWord,
    List<String>? careers,
    String? knowledge,
  }) {
    return IntershipModel(
      title: title ?? this.title,
      department: department ?? this.department,
      deadline: deadline ?? this.deadline,
      days: days ?? this.days,
      duration: duration ?? this.duration,
      startDate: startDate ?? this.startDate,
      endDate: endDate ?? this.endDate,
      description: description ?? this.description,
      urlPDF: urlPDF ?? this.urlPDF,
      urlWord: urlWord ?? this.urlWord,
      careers: careers ?? this.careers,
      knowledge: knowledge ?? this.knowledge,
    );
  }

  @override
  // TODO: implement props
  List<Object?> get props => [
    title,
    department,
    deadline,
    days,
    duration,
    startDate,
    endDate,
    description,
    urlPDF,
    urlWord,
    careers,
    knowledge,
  ];
}
