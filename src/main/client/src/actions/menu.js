import { HIDE_MENU, SHOW_MENU } from "../constants/actionTypes";

export const showMenu = () => {
	return {
		type: SHOW_MENU
	}
}

export const hideMenu = () => {
	return {
		type: HIDE_MENU
	}
}

