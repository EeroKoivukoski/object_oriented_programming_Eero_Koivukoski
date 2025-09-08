**Call Centre Simulation: Clock 0 (Initialize simulation)**

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|-------|--------------|--------|--------------|--------|--------------|--------|
|       | Empty        | Idle   | Empty        | Idle   | Empty        | Idle   |

Event List:

| Event | Time |
|-------|------|
| B1    | 5    |
| B2    | 10   |

Results:

| Work<br>complete |   |
|------------------|---|
| X                | 0 |
| Y                | 0 |

**Call Centre Simulation: Clock 5 (Event B1)**

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|-------|--------------|--------|--------------|--------|--------------|--------|
| B     | X1           | Idle   | Empty        | Idle   | Empty        | Idle   |
| C     | Empty        | X1     | Empty        | Idle   | Empty        | Idle   |

Event List:

| Event | Time |
|-------|------|
| B3    | 6    |
| B2    | 10   |
| B1    | 10   |

Results:

| Work<br>complete |   |
|------------------|---|
| X                | 0 |
| Y                | 0 |

**Call Centre Simulation: Clock 6 (Event B3)**

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|-------|--------------|--------|--------------|--------|--------------|--------|
| B     | Empty        | Idle   | X1           | Idle   | Empty        | Idle   |
| C     | Empty        | Idle   | Empty        | X1     | Empty        | Idle   |

Event List:

| Event | Time |
|-------|------|
| B2    | 10   |
| B1    | 10   |
| B4    | 10   |


Results:

| Work<br>complete |   |
|------------------|---|
| X                | 0 |
| Y                | 0 |

**Call Centre Simulation: Clock 10 (Events B2,B1,B4)**

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|-------|--------------|--------|--------------|--------|--------------|--------|
| B     | X2,Y1        | Idle   | Empty        | Idle   | Empty        | Idle   |
| C     | X2           | Y1     | Empty        | Idle   | Empty        | Idle   |

Event List:

| Event | Time |
|-------|------|
| B3    | 11   |
| B1    | 15   |
| B2    | 20   |

Results:

| Work<br>complete |   |
|------------------|---|
| X                | 1 |
| Y                | 0 |


**Call Centre Simulation: Clock 11 (Event B3)**

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|-------|--------------|--------|--------------|--------|--------------|--------|
| B     | X2           | Idle   | Empty        | Idle   | Y1           | Idle   |
| C     | Empty        | X2     | Empty        | Idle   | Empty        | Y1     |

Event List:

| Event | Time |
|-------|------|
| B3    | 12   |
| B1    | 15   |
| B5    | 18   |
| B2    | 20   |

Results:

| Work<br>complete |   |
|------------------|---|
| X                | 1 |
| Y                | 0 |


**Call Centre Simulation: Clock 12 (Event B3)**

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|-------|--------------|--------|--------------|--------|--------------|--------|
| B     | Empty        | Idle   | X2           | Idle   | Empty        | Y1     |
| C     | Empty        | Idle   | Empty        | X2     | Empty        | Y1     |

Event List:

| Event | Time |
|-------|------|
| B1    | 15   |
| B4    | 16   |
| B5    | 18   |
| B2    | 20   |

Results:

| Work<br>complete |   |
|------------------|---|
| X                | 1 |
| Y                | 0 |


**Call Centre Simulation: Clock 15 (Event B1)**

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|-------|--------------|--------|--------------|--------|--------------|--------|
| B     | X3           | Idle   | Empty        | X2     | Empty        | Y1     |
| C     | Empty        | X3     | Empty        | X2     | Empty        | Y1     |

Event List:

| Event | Time |
|-------|------|
| B4    | 16   |
| B3    | 16   |
| B5    | 18   |
| B1    | 20   |
| B2    | 20   |

Results:

| Work<br>complete |   |
|------------------|---|
| X                | 1 |
| Y                | 0 |

**Call Centre Simulation: Clock 16 (Event B4,B3)**

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|-------|--------------|--------|--------------|--------|--------------|--------|
| B     | X3           | Idle   | Empty        | X2     | Empty        | Y1     |
| C     | Empty        | Idle   | Empty        | X3     | Empty        | Y1     |

Event List:

| Event | Time |
|-------|------|
| B5    | 18   |
| B1    | 20   |
| B2    | 20   |
| B4    | 20   |

Results:

| Work<br>complete |   |
|------------------|---|
| X                | 2 |
| Y                | 0 |

**Call Centre Simulation: Clock 18 (Event B5)**

| Phase | Router Queue | Router | Oper 1 queue | Oper 1 | Oper 2 queue | Oper 2 |
|-------|--------------|--------|--------------|--------|--------------|--------|
| B     | Empty        | Idle   | Empty        | X3     | Empty        | Y1     |
| C     | Empty        | Idle   | Empty        | X3     | Empty        | Idle   |

Event List:

| Event | Time |
|-------|------|
| B1    | 20   |
| B2    | 20   |
| B4    | 20   |

Results:

| Work<br>complete |   |
|------------------|---|
| X                | 2 |
| Y                | 1 |

Vastaus: ajassa 18 on ensimmäinen y asiakas poistunut.