import { makeStyles } from '@material-ui/core';

export default makeStyles({
  buttonContainer: {
    marginTop: "15px",
    position: "relative"
  },
  info: {
    paddingLeft: "30px"
  },
  filmInfo: {
    '& p': {
      color: "grey",
      fontSize: "1.2em",
      margin: "5px"
    },
    '& span': {
      color: "rgb(230,230,230)"
    }
  },
  logo: {
    borderRadius: "8px",
    maxHeight: "400px",
    maxWidth: "100%",
  },
  sessionsContainer: {
    backgroundColor: "rgba(95,91,91,0.9)",
    marginTop: "52px",
    padding: "5vh 10vh",
    minHeight: "calc(100vh - 250px)"
  },
  plot: {
    marginTop: "25px"
  },
  title: {
    // display: "flex",
    // justifyContent: "center",
    padding: "0 10px",
    fontSize: "30px",
    marginBottom: "15px",
    '& p': {
      color: "rgb(230,230,230)"
    }
  }
})