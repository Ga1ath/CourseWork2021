import { makeStyles } from '@material-ui/core';

export default makeStyles({
  date: {
    color: "white",
    fontWeight: "200"
  },
  // sessions: {
  //   display: "flex",
  //   alignContent: 'end'
  // },
  sessionContainer: {
    borderTop: "solid",
    borderColor: "grey",
    borderWidth: "1px",
    display: "flex",
    flexDirection: "row"
  },
  curDate: {
    fontWeight: "150",
    fontFamily: "arial, helvetica",
    fontSize: "1.75em"
  }
})