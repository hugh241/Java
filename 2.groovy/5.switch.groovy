def var = 1.2f
switch(var){
    case 0:println 'One'
    case 11..20: println 'Two'
    case '10':println 'Three'
    case [1,2,3]:println 'Four'
    case Float:println 'Five'
    case {it%3==0}:println 'Six'
    case ~'[0-9]{3}':println 'Seven'
    default:println 'Default'
}