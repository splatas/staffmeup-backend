# Proyecto

- Nombre del proyecto: **Staffing Follower**
- POD: **Postres** (#3)

# Diseño

Ver un mock interactivo del diseño en [Marvel App](https://marvelapp.com/35f0ai0/screen/47999475)

# Desarrollo

## Tecnologías (Backend)

- JAVA
- MySQL
- ...

## End points

### Principales

Obtener todos los tickets sin los candidatos (solo descripciones, sin objetos)
- http://10.20.10.218:8080/ticket/getonlytickets

Obtener todos candidatos (solo descripciones, sin objetos)
- http://10.20.10.218:8080/candidate/getcandidatesview


### Todos

#### Ticket

- http://10.20.10.218:8081/ticket/getticket/{id}
- http://10.20.10.218:8081/ticket/gettickets
- http://10.20.10.218:8081/ticket/getonlytickets
- http://10.20.10.218:8081/ticket/saveticket
- http://10.20.10.218:8081/ticket/getticketreport

#### Ticket History

- http://10.20.10.218:8081/tickethistory/gethistory/{id}
- http://10.20.10.218:8081/tickethistory/getall
- http://10.20.10.218:8081/tickethistory/saveHistory

#### Candidate

- http://10.20.10.218:8081/candidate/getcandidate/{id}
- http://10.20.10.218:8081/candidate/getcandidates
- http://10.20.10.218:8081/candidate/getcandidatesview
- http://10.20.10.218:8081/candidate/savecandidate

#### Candidate History

- http://10.20.10.218:8081/candidatehistory/gethistory/{id}
- http://10.20.10.218:8081/candidatehistory/getall
- http://10.20.10.218:8081/candidatehistory/savehistory

#### Candidate Status

- http://10.20.10.218:8081/candidatestatus/getall
- http://10.20.10.218:8081/candidatestatus/findcandidatesatusbyid/{id}
- http://10.20.10.218:8081/candidatestatus/savecandidatestatus

#### Location

- http://10.20.10.218:8081/location/getall
- http://10.20.10.218:8081/location/getlocation/{id}
- http://10.20.10.218:8081/location/savelocation

#### Onboarding

- http://10.20.10.218:8081/onboarding/getall
- http://10.20.10.218:8081/onboarding/getonboarding/{id}
- http://10.20.10.218:8081/onboarding/saveonboarding

#### Position

- http://10.20.10.218:8081/position/getall
- http://10.20.10.218:8081/position/getposition/{id}
- http://10.20.10.218:8081/position/saveposition

#### Priority

- http://10.20.10.218:8081/priority/getall
- http://10.20.10.218:8081/priority/getpriority/{id}
- http://10.20.10.218:8081/priority/savepriority

#### Profile

- http://10.20.10.218:8081/profile/getall
- http://10.20.10.218:8081/profile/getprofile/{id}
- http://10.20.10.218:8081/profile/saveprofile

#### Seniority

- http://10.20.10.218:8081/seniority/getall
- http://10.20.10.218:8081/seniority/getseniority/{id}
- http://10.20.10.218:8081/seniority/saveseniority

#### Status

- http://10.20.10.218:8081/status/getall
- http://10.20.10.218:8081/status/getstatus/{id}
- http://10.20.10.218:8081/status/savestatus

#### Import

- http://10.20.10.218:8081/import/sheetTicketCandidate


