import 'package:equatable/equatable.dart';
import 'package:intl/intl.dart';

class IntershipModel extends Equatable {
  final int idInternship;
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
  final String careers;
  final String knowledge;
  IntershipModel({
    this.idInternship = 0,
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
      idInternship: json['idInternship'],
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
      careers: json['careers'],
      knowledge: json['knowledge'],
    );
  }
  Map<String, dynamic> toJson() {
    return {
      'idInternship': idInternship,
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
    int? idInternship,
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
    String? careers,
    String? knowledge,
  }) {
    return IntershipModel(
      idInternship: idInternship ?? this.idInternship,
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
        idInternship,
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

  static IntershipModel fromMap(Map<String, dynamic> map) {
    DateFormat timeFormat = DateFormat('HH:mm:ss');
    DateTime startDate2 = timeFormat.parse(map['startDate']);
    DateTime startDate3 = timeFormat.parse(map['endDate']);
    return IntershipModel(
      idInternship: map['idInternship'],
      title: map['title'],
      department: map['department'],
      deadline: DateTime.parse(map['deadline']),
      days: map['days'],
      duration: map['duration'],
      startDate: startDate2,
      endDate: startDate3,
      description: map['description'],
      urlPDF: map['urlPDF'],
      urlWord: map['urlWORD'],
      careers: map['careers'].toString(),
      knowledge: map['knowledge'],
    );
  }
}
