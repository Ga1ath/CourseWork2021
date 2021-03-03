import { FETCH_SESSIONS } from '../constants/actionTypes';

const initialState = {
  filmName: "Imbasaurus",
  length: "1h10min",
  mainRoles: "djanelli, xelathecreator, childish imbino",
  logo: "https://sun9-70.userapi.com/impf/R3TZ5ETeWV7ke9Uqlmg0TX_7_c5HvQGBrXiLSA/Rfw-rBqb0B4.jpg?size=939x994&quality=96&proxy=1&sign=900f4dfc77d16d7f0b46feb5ad9b36fe&type=album",
  rated: 9.8,
  director: "Jean Paul Macron",
  plot: "once upon a time a nibba shot his gay friend and it become obvious to him that he loved that gayshitman more than everyone else so he commited suicide",
  sessions: [
    {
      id: 1,
      date: 'January 14th',
      time: '14:10',
      price: 300,
      hall: "nibbers"
    },
    {
      id: 2,
      date: 'January 14th',
      time: '14:40',
      price: 350,
      hall: "imbasaurus"
    },
    {
      id: 3,
      date: 'January 16th',
      time: '14:10',
      price: 300,
      hall: "nibbers"
    },
    {
      id: 4,
      date: 'January 18th',
      time: '14:10',
      price: 400,
      hall: "nibbers"
    },
    {
      id: 5,
      date: 'January 18th',
      time: '18:10',
      price: 300,
      hall: "imbasaurus"
    },
    {
      id: 6,
      date: 'January 21th',
      time: '12:10',
      price: 230,
      hall: "nibbers"
    },
    {
      id: 7,
      date: 'January 21th',
      time: '14:10',
      price: 300,
      hall: "imbasaurus"
    },
    {
      id: 8,
      date: 'January 21th',
      time: '21:10',
      price: 300,
      hall: "nibbers"
    }
  ]
}

const reducer = (filmInfo = initialState, action) => {
  switch (action.type) {
    case FETCH_SESSIONS:
      return action.payload;
    default:
      return filmInfo;
  }
}

export default reducer;