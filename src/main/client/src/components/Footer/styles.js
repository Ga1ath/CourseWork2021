import { makeStyles } from '@material-ui/core';

export default makeStyles({
  appBar: {
    backgroundColor: 'black',
    position: "absolute",
    //padding: "0",
    width: "100%",
    marginTop: "calc(100%+60px)",
    //bottom: "0",
    top: "inherit",
    zIndex: 10,
  },
  toolbar: {
    display: "flex",
    justifyContent: "center",
  }
})