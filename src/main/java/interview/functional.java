//
//ZERO(X), INCR(X), REPEAT(X)
//
///*Given Y, Let X=Y*/
//ASSG(X,Y){
//	ZERO(X);
//	REPEAT(Y){
//	  INCR(X);
//	}
//}
//
//DECR(X){
//	ZERO(G);
//	ZERO(H);
//	REPEAT(X){
//	  ASSG(G,H);
//	  INCR(H);
//	}
//	ASSG(X,G);
//}
//
//ADD(X,Y){
//	ZERO(M);
//	ASSG(M,X);
//	REPEAT(Y){
//		INCR(M);
//	}
//	ASSG(X,M)
//}
//
//SUB(X,Y){
//	ZERO(M);
//	ASSG(M,X);
//	REPEAT(Y){
//		DECR(M);
//	}
//	ASSG(X,M);
//
//}
//
//MUL(X,Y){
//	ZERO(M);
//	REPEAT(Y){
//		ADD(M,X);
//	}
//	ASSG(X,M);
//}
////if x is 0, G is 0; else G is 1.
//SIGN(X,G){
//	ZERO(G);
//	ZERO(H);
//	INCR(H);
//	REPEAT(X){
//		ASSG(G,H);
//	}
//}
//
//DIV(X,Y,R){
//    ZERO(J);
//    ZERO(C);
//    REPEAT(X){
//    	ASSG(H,X);
//    	INCR(H);
//    	SUB(H,Y);
//    	INCR(C);
//    	REPEAT(H){
//    		ASSG(X,H);
//    		DECR(X);
//    		ASSG(J,C);
//    	}
//    }
//	ASSG(R,X);
//	ASSG(X,J);
//}
//
//
//
