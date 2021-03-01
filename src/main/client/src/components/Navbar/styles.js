import { makeStyles } from '@material-ui/core/styles';
import { fade } from "@material-ui/core";

export default makeStyles((theme) => ({
	appBar: {
		backgroundColor: "black",
	},
	menuButton: {
		marginRight: theme.spacing(2),
	},
	title: {
		flexGrow: 1,
		display: 'none',
		[theme.breakpoints.up('sm')]: {
			display: 'flex',
			flexDirection: 'row',
			justifyContent: 'space-between',
		},
	},
	search: {
		position: 'relative',
		borderRadius: theme.shape.borderRadius,
		backgroundColor: fade(theme.palette.common.white, 0.15),
		'&:hover': {
			backgroundColor: fade(theme.palette.common.white, 0.25),
		},
		margin: "0 5px 0 15px",
		width: '100%',
		[theme.breakpoints.up('sm')]: {
			marginLeft: theme.spacing(1),
			width: 'auto',
		},
	},
	searchIcon: {
		padding: theme.spacing(0, 2),
		height: '100%',
		position: 'absolute',
		pointerEvents: 'none',
		display: 'flex',
		alignItems: 'center',
		justifyContent: 'center',
	},
	inputRoot: {
		color: 'inherit',
	},
	inputInput: {
		padding: theme.spacing(1, 1, 1, 0),
		paddingLeft: `calc(1em + ${theme.spacing(4)}px)`,
		transition: theme.transitions.create('width'),
		width: '100%',
		[theme.breakpoints.up('sm')]: {
			width: '12ch',
			'&:focus': {
				width: '20ch',
			},
		},
	},
	navMenu: {
		backgroundColor: "black",
		width: "200px",
		height: "100vh",
		display: "flex",
		justifyContent: "center",
		position: "fixed",
		top: "60px",
		left: "-100%",
		transition: "850ms",
		zIndex: "2002"
	},
	navText: {
		display: "flex",
		justifyContent: "start",
		alignItems: "center",
		padding: "8px 0px 8px 16px",
		height: "60px",
		listStyle: "none",
		"&:hover": {
			backgroundColor: "#1a83ff",
		},
		"& > a": {
			textDecoration: "none",
			color: "#f5f5f5",
			fontSize: "18px",
			width: "95%",
			height: "100%",
			display: "flex",
			alignItems: "center",
			padding: "0 16px",
			borderRadius: "4px",
		},
	},
	active: {
		left: "0",
		transition: "350ms"
	},
	navMenuItems: {
		width: "100%",
		paddingLeft: "0"
	},
	navbarToggle: {
		backgroundColor: "black",
		width: "100%",
		//height: "80px",
		display: "flex",
		justifyContent: "start",
		alignItems: "center"
	},
	menuBars: {
		marginLeft: "2rem",
		fontSize: "2rem"
	},

}));
