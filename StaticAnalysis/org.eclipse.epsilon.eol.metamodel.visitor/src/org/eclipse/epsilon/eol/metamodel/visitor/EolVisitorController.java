package org.eclipse.epsilon.eol.metamodel.visitor;

import org.eclipse.epsilon.eol.metamodel.*;
import org.eclipse.emf.ecore.EObject;
import java.util.List;
import java.util.ArrayList;




public class EolVisitorController<T, R> {

	protected List<OrderedSetTypeVisitor<T, R>> orderedSetTypeVisitors = new ArrayList<OrderedSetTypeVisitor<T, R>>();
	protected List<AndOperatorExpressionVisitor<T, R>> andOperatorExpressionVisitors = new ArrayList<AndOperatorExpressionVisitor<T, R>>();
	protected List<BooleanExpressionVisitor<T, R>> booleanExpressionVisitors = new ArrayList<BooleanExpressionVisitor<T, R>>();
	protected List<DivideOperatorExpressionVisitor<T, R>> divideOperatorExpressionVisitors = new ArrayList<DivideOperatorExpressionVisitor<T, R>>();
	protected List<EqualsOperatorExpressionVisitor<T, R>> equalsOperatorExpressionVisitors = new ArrayList<EqualsOperatorExpressionVisitor<T, R>>();
	protected List<GreaterThanOperatorExpressionVisitor<T, R>> greaterThanOperatorExpressionVisitors = new ArrayList<GreaterThanOperatorExpressionVisitor<T, R>>();
	protected List<GreaterThanOrEqualToOperatorExpressionVisitor<T, R>> greaterThanOrEqualToOperatorExpressionVisitors = new ArrayList<GreaterThanOrEqualToOperatorExpressionVisitor<T, R>>();
	protected List<ImpliesOperatorExpressionVisitor<T, R>> impliesOperatorExpressionVisitors = new ArrayList<ImpliesOperatorExpressionVisitor<T, R>>();
	protected List<IntegerExpressionVisitor<T, R>> integerExpressionVisitors = new ArrayList<IntegerExpressionVisitor<T, R>>();
	protected List<LessThanOperatorExpressionVisitor<T, R>> lessThanOperatorExpressionVisitors = new ArrayList<LessThanOperatorExpressionVisitor<T, R>>();
	protected List<LessThanOrEqualToOperatorExpressionVisitor<T, R>> lessThanOrEqualToOperatorExpressionVisitors = new ArrayList<LessThanOrEqualToOperatorExpressionVisitor<T, R>>();
	protected List<MinusOperatorExpressionVisitor<T, R>> minusOperatorExpressionVisitors = new ArrayList<MinusOperatorExpressionVisitor<T, R>>();
	protected List<MultiplyOperatorExpressionVisitor<T, R>> multiplyOperatorExpressionVisitors = new ArrayList<MultiplyOperatorExpressionVisitor<T, R>>();
	protected List<NegativeOperatorExpressionVisitor<T, R>> negativeOperatorExpressionVisitors = new ArrayList<NegativeOperatorExpressionVisitor<T, R>>();
	protected List<NotEqualsOperatorExpressionVisitor<T, R>> notEqualsOperatorExpressionVisitors = new ArrayList<NotEqualsOperatorExpressionVisitor<T, R>>();
	protected List<NotOperatorExpressionVisitor<T, R>> notOperatorExpressionVisitors = new ArrayList<NotOperatorExpressionVisitor<T, R>>();
	protected List<OrOperatorExpressionVisitor<T, R>> orOperatorExpressionVisitors = new ArrayList<OrOperatorExpressionVisitor<T, R>>();
	protected List<PlusOperatorExpressionVisitor<T, R>> plusOperatorExpressionVisitors = new ArrayList<PlusOperatorExpressionVisitor<T, R>>();
	protected List<RealExpressionVisitor<T, R>> realExpressionVisitors = new ArrayList<RealExpressionVisitor<T, R>>();
	protected List<StringExpressionVisitor<T, R>> stringExpressionVisitors = new ArrayList<StringExpressionVisitor<T, R>>();
	protected List<XorOperatorExpressionVisitor<T, R>> xorOperatorExpressionVisitors = new ArrayList<XorOperatorExpressionVisitor<T, R>>();
	protected List<SetExpressionVisitor<T, R>> setExpressionVisitors = new ArrayList<SetExpressionVisitor<T, R>>();
	protected List<BagExpressionVisitor<T, R>> bagExpressionVisitors = new ArrayList<BagExpressionVisitor<T, R>>();
	protected List<SequenceExpressionVisitor<T, R>> sequenceExpressionVisitors = new ArrayList<SequenceExpressionVisitor<T, R>>();
	protected List<OrderedSetExpressionVisitor<T, R>> orderedSetExpressionVisitors = new ArrayList<OrderedSetExpressionVisitor<T, R>>();
	protected List<SetTypeVisitor<T, R>> setTypeVisitors = new ArrayList<SetTypeVisitor<T, R>>();
	protected List<SequenceTypeVisitor<T, R>> sequenceTypeVisitors = new ArrayList<SequenceTypeVisitor<T, R>>();
	protected List<BinaryOperatorExpressionVisitor<T, R>> binaryOperatorExpressionVisitors = new ArrayList<BinaryOperatorExpressionVisitor<T, R>>();
	protected List<MethodCallExpressionVisitor<T, R>> methodCallExpressionVisitors = new ArrayList<MethodCallExpressionVisitor<T, R>>();
	protected List<UnaryOperatorExpressionVisitor<T, R>> unaryOperatorExpressionVisitors = new ArrayList<UnaryOperatorExpressionVisitor<T, R>>();
	protected List<PropertyCallExpressionVisitor<T, R>> propertyCallExpressionVisitors = new ArrayList<PropertyCallExpressionVisitor<T, R>>();
	protected List<FOLMethodCallExpressionVisitor<T, R>> fOLMethodCallExpressionVisitors = new ArrayList<FOLMethodCallExpressionVisitor<T, R>>();
	protected List<SwitchCaseDefaultStatementVisitor<T, R>> switchCaseDefaultStatementVisitors = new ArrayList<SwitchCaseDefaultStatementVisitor<T, R>>();
	protected List<SwitchCaseExpressionStatementVisitor<T, R>> switchCaseExpressionStatementVisitors = new ArrayList<SwitchCaseExpressionStatementVisitor<T, R>>();
	protected List<PrimitiveExpressionVisitor<T, R>> primitiveExpressionVisitors = new ArrayList<PrimitiveExpressionVisitor<T, R>>();
	protected List<CollectionExpressionVisitor<T, R>> collectionExpressionVisitors = new ArrayList<CollectionExpressionVisitor<T, R>>();
	protected List<MapExpressionVisitor<T, R>> mapExpressionVisitors = new ArrayList<MapExpressionVisitor<T, R>>();
	protected List<BooleanTypeVisitor<T, R>> booleanTypeVisitors = new ArrayList<BooleanTypeVisitor<T, R>>();
	protected List<IntegerTypeVisitor<T, R>> integerTypeVisitors = new ArrayList<IntegerTypeVisitor<T, R>>();
	protected List<RealTypeVisitor<T, R>> realTypeVisitors = new ArrayList<RealTypeVisitor<T, R>>();
	protected List<StringTypeVisitor<T, R>> stringTypeVisitors = new ArrayList<StringTypeVisitor<T, R>>();
	protected List<BagTypeVisitor<T, R>> bagTypeVisitors = new ArrayList<BagTypeVisitor<T, R>>();
	protected List<SpecialNameExpressionVisitor<T, R>> specialNameExpressionVisitors = new ArrayList<SpecialNameExpressionVisitor<T, R>>();
	protected List<ModelExpressionVisitor<T, R>> modelExpressionVisitors = new ArrayList<ModelExpressionVisitor<T, R>>();
	protected List<FormalParameterExpressionVisitor<T, R>> formalParameterExpressionVisitors = new ArrayList<FormalParameterExpressionVisitor<T, R>>();
	protected List<SpecialAssignmentStatementVisitor<T, R>> specialAssignmentStatementVisitors = new ArrayList<SpecialAssignmentStatementVisitor<T, R>>();
	protected List<NativeExpressionVisitor<T, R>> nativeExpressionVisitors = new ArrayList<NativeExpressionVisitor<T, R>>();
	protected List<SelfTypeVisitor<T, R>> selfTypeVisitors = new ArrayList<SelfTypeVisitor<T, R>>();
	protected List<SelfContentTypeVisitor<T, R>> selfContentTypeVisitors = new ArrayList<SelfContentTypeVisitor<T, R>>();
	protected List<OrderedCollectionTypeVisitor<T, R>> orderedCollectionTypeVisitors = new ArrayList<OrderedCollectionTypeVisitor<T, R>>();
	protected List<UniqueCollectionTypeVisitor<T, R>> uniqueCollectionTypeVisitors = new ArrayList<UniqueCollectionTypeVisitor<T, R>>();
	protected List<SelfInnermostTypeVisitor<T, R>> selfInnermostTypeVisitors = new ArrayList<SelfInnermostTypeVisitor<T, R>>();
	protected List<OperationArgTypeVisitor<T, R>> operationArgTypeVisitors = new ArrayList<OperationArgTypeVisitor<T, R>>();
	protected List<OperatorExpressionVisitor<T, R>> operatorExpressionVisitors = new ArrayList<OperatorExpressionVisitor<T, R>>();
	protected List<LiteralExpressionVisitor<T, R>> literalExpressionVisitors = new ArrayList<LiteralExpressionVisitor<T, R>>();
	protected List<EnumerationLiteralExpressionVisitor<T, R>> enumerationLiteralExpressionVisitors = new ArrayList<EnumerationLiteralExpressionVisitor<T, R>>();
	protected List<FeatureCallExpressionVisitor<T, R>> featureCallExpressionVisitors = new ArrayList<FeatureCallExpressionVisitor<T, R>>();
	protected List<NameExpressionVisitor<T, R>> nameExpressionVisitors = new ArrayList<NameExpressionVisitor<T, R>>();
	protected List<VariableDeclarationExpressionVisitor<T, R>> variableDeclarationExpressionVisitors = new ArrayList<VariableDeclarationExpressionVisitor<T, R>>();
	protected List<AssignmentStatementVisitor<T, R>> assignmentStatementVisitors = new ArrayList<AssignmentStatementVisitor<T, R>>();
	protected List<BreakStatementVisitor<T, R>> breakStatementVisitors = new ArrayList<BreakStatementVisitor<T, R>>();
	protected List<BreakAllStatementVisitor<T, R>> breakAllStatementVisitors = new ArrayList<BreakAllStatementVisitor<T, R>>();
	protected List<ContinueStatementVisitor<T, R>> continueStatementVisitors = new ArrayList<ContinueStatementVisitor<T, R>>();
	protected List<DeleteStatementVisitor<T, R>> deleteStatementVisitors = new ArrayList<DeleteStatementVisitor<T, R>>();
	protected List<ForStatementVisitor<T, R>> forStatementVisitors = new ArrayList<ForStatementVisitor<T, R>>();
	protected List<IfStatementVisitor<T, R>> ifStatementVisitors = new ArrayList<IfStatementVisitor<T, R>>();
	protected List<ReturnStatementVisitor<T, R>> returnStatementVisitors = new ArrayList<ReturnStatementVisitor<T, R>>();
	protected List<SwitchStatementVisitor<T, R>> switchStatementVisitors = new ArrayList<SwitchStatementVisitor<T, R>>();
	protected List<SwitchCaseStatementVisitor<T, R>> switchCaseStatementVisitors = new ArrayList<SwitchCaseStatementVisitor<T, R>>();
	protected List<WhileStatementVisitor<T, R>> whileStatementVisitors = new ArrayList<WhileStatementVisitor<T, R>>();
	protected List<ModelDeclarationStatementVisitor<T, R>> modelDeclarationStatementVisitors = new ArrayList<ModelDeclarationStatementVisitor<T, R>>();
	protected List<ExpressionStatementVisitor<T, R>> expressionStatementVisitors = new ArrayList<ExpressionStatementVisitor<T, R>>();
	protected List<AnyTypeVisitor<T, R>> anyTypeVisitors = new ArrayList<AnyTypeVisitor<T, R>>();
	protected List<CollectionTypeVisitor<T, R>> collectionTypeVisitors = new ArrayList<CollectionTypeVisitor<T, R>>();
	protected List<PrimitiveTypeVisitor<T, R>> primitiveTypeVisitors = new ArrayList<PrimitiveTypeVisitor<T, R>>();
	protected List<MapTypeVisitor<T, R>> mapTypeVisitors = new ArrayList<MapTypeVisitor<T, R>>();
	protected List<ExecutableAnnotationVisitor<T, R>> executableAnnotationVisitors = new ArrayList<ExecutableAnnotationVisitor<T, R>>();
	protected List<SimpleAnnotationVisitor<T, R>> simpleAnnotationVisitors = new ArrayList<SimpleAnnotationVisitor<T, R>>();
	protected List<ModelElementTypeVisitor<T, R>> modelElementTypeVisitors = new ArrayList<ModelElementTypeVisitor<T, R>>();
	protected List<NativeTypeVisitor<T, R>> nativeTypeVisitors = new ArrayList<NativeTypeVisitor<T, R>>();
	protected List<ThrowStatementVisitor<T, R>> throwStatementVisitors = new ArrayList<ThrowStatementVisitor<T, R>>();
	protected List<AbortStatementVisitor<T, R>> abortStatementVisitors = new ArrayList<AbortStatementVisitor<T, R>>();
	protected List<TransactionStatementVisitor<T, R>> transactionStatementVisitors = new ArrayList<TransactionStatementVisitor<T, R>>();
	protected List<ExprListVisitor<T, R>> exprListVisitors = new ArrayList<ExprListVisitor<T, R>>();
	protected List<ExpRangeVisitor<T, R>> expRangeVisitors = new ArrayList<ExpRangeVisitor<T, R>>();
	protected List<NewExpressionVisitor<T, R>> newExpressionVisitors = new ArrayList<NewExpressionVisitor<T, R>>();
	protected List<ModelTypeVisitor<T, R>> modelTypeVisitors = new ArrayList<ModelTypeVisitor<T, R>>();
	protected List<ETypeVisitor<T, R>> eTypeVisitors = new ArrayList<ETypeVisitor<T, R>>();
	protected List<VoidTypeVisitor<T, R>> voidTypeVisitors = new ArrayList<VoidTypeVisitor<T, R>>();
	protected List<PseudoTypeVisitor<T, R>> pseudoTypeVisitors = new ArrayList<PseudoTypeVisitor<T, R>>();
	protected List<ProgramVisitor<T, R>> programVisitors = new ArrayList<ProgramVisitor<T, R>>();
	protected List<ImportVisitor<T, R>> importVisitors = new ArrayList<ImportVisitor<T, R>>();
	protected List<StatementVisitor<T, R>> statementVisitors = new ArrayList<StatementVisitor<T, R>>();
	protected List<ExpressionVisitor<T, R>> expressionVisitors = new ArrayList<ExpressionVisitor<T, R>>();
	protected List<BlockVisitor<T, R>> blockVisitors = new ArrayList<BlockVisitor<T, R>>();
	protected List<OperationDefinitionVisitor<T, R>> operationDefinitionVisitors = new ArrayList<OperationDefinitionVisitor<T, R>>();
	protected List<TypeVisitor<T, R>> typeVisitors = new ArrayList<TypeVisitor<T, R>>();
	protected List<AnnotationVisitor<T, R>> annotationVisitors = new ArrayList<AnnotationVisitor<T, R>>();
	protected List<KeyValueVisitor<T, R>> keyValueVisitors = new ArrayList<KeyValueVisitor<T, R>>();
	protected List<AnnotationBlockVisitor<T, R>> annotationBlockVisitors = new ArrayList<AnnotationBlockVisitor<T, R>>();
	protected List<ModelDeclarationParameterVisitor<T, R>> modelDeclarationParameterVisitors = new ArrayList<ModelDeclarationParameterVisitor<T, R>>();
	protected List<CollectionInitValueVisitor<T, R>> collectionInitValueVisitors = new ArrayList<CollectionInitValueVisitor<T, R>>();
	protected List<EolElementVisitor<T, R>> eolElementVisitors = new ArrayList<EolElementVisitor<T, R>>();
	protected List<TextRegionVisitor<T, R>> textRegionVisitors = new ArrayList<TextRegionVisitor<T, R>>();
	protected List<TextPositionVisitor<T, R>> textPositionVisitors = new ArrayList<TextPositionVisitor<T, R>>();
	protected List<EolDefaultVisitor<T, R>> defaultVisitors = new ArrayList<EolDefaultVisitor<T, R>>();
	
	public R visit(EObject o, T context) {
		if (o instanceof OrderedSetType && !orderedSetTypeVisitors.isEmpty()) {
			for (OrderedSetTypeVisitor<T, R> visitor : orderedSetTypeVisitors) {
				if (visitor.appliesTo((OrderedSetType) o, context)) {
					return visitor.visit((OrderedSetType) o, context, this);
				}
			}
		}
		if (o instanceof AndOperatorExpression && !andOperatorExpressionVisitors.isEmpty()) {
			for (AndOperatorExpressionVisitor<T, R> visitor : andOperatorExpressionVisitors) {
				if (visitor.appliesTo((AndOperatorExpression) o, context)) {
					return visitor.visit((AndOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof BooleanExpression && !booleanExpressionVisitors.isEmpty()) {
			for (BooleanExpressionVisitor<T, R> visitor : booleanExpressionVisitors) {
				if (visitor.appliesTo((BooleanExpression) o, context)) {
					return visitor.visit((BooleanExpression) o, context, this);
				}
			}
		}
		if (o instanceof DivideOperatorExpression && !divideOperatorExpressionVisitors.isEmpty()) {
			for (DivideOperatorExpressionVisitor<T, R> visitor : divideOperatorExpressionVisitors) {
				if (visitor.appliesTo((DivideOperatorExpression) o, context)) {
					return visitor.visit((DivideOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof EqualsOperatorExpression && !equalsOperatorExpressionVisitors.isEmpty()) {
			for (EqualsOperatorExpressionVisitor<T, R> visitor : equalsOperatorExpressionVisitors) {
				if (visitor.appliesTo((EqualsOperatorExpression) o, context)) {
					return visitor.visit((EqualsOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof GreaterThanOperatorExpression && !greaterThanOperatorExpressionVisitors.isEmpty()) {
			for (GreaterThanOperatorExpressionVisitor<T, R> visitor : greaterThanOperatorExpressionVisitors) {
				if (visitor.appliesTo((GreaterThanOperatorExpression) o, context)) {
					return visitor.visit((GreaterThanOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof GreaterThanOrEqualToOperatorExpression && !greaterThanOrEqualToOperatorExpressionVisitors.isEmpty()) {
			for (GreaterThanOrEqualToOperatorExpressionVisitor<T, R> visitor : greaterThanOrEqualToOperatorExpressionVisitors) {
				if (visitor.appliesTo((GreaterThanOrEqualToOperatorExpression) o, context)) {
					return visitor.visit((GreaterThanOrEqualToOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof ImpliesOperatorExpression && !impliesOperatorExpressionVisitors.isEmpty()) {
			for (ImpliesOperatorExpressionVisitor<T, R> visitor : impliesOperatorExpressionVisitors) {
				if (visitor.appliesTo((ImpliesOperatorExpression) o, context)) {
					return visitor.visit((ImpliesOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof IntegerExpression && !integerExpressionVisitors.isEmpty()) {
			for (IntegerExpressionVisitor<T, R> visitor : integerExpressionVisitors) {
				if (visitor.appliesTo((IntegerExpression) o, context)) {
					return visitor.visit((IntegerExpression) o, context, this);
				}
			}
		}
		if (o instanceof LessThanOperatorExpression && !lessThanOperatorExpressionVisitors.isEmpty()) {
			for (LessThanOperatorExpressionVisitor<T, R> visitor : lessThanOperatorExpressionVisitors) {
				if (visitor.appliesTo((LessThanOperatorExpression) o, context)) {
					return visitor.visit((LessThanOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof LessThanOrEqualToOperatorExpression && !lessThanOrEqualToOperatorExpressionVisitors.isEmpty()) {
			for (LessThanOrEqualToOperatorExpressionVisitor<T, R> visitor : lessThanOrEqualToOperatorExpressionVisitors) {
				if (visitor.appliesTo((LessThanOrEqualToOperatorExpression) o, context)) {
					return visitor.visit((LessThanOrEqualToOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof MinusOperatorExpression && !minusOperatorExpressionVisitors.isEmpty()) {
			for (MinusOperatorExpressionVisitor<T, R> visitor : minusOperatorExpressionVisitors) {
				if (visitor.appliesTo((MinusOperatorExpression) o, context)) {
					return visitor.visit((MinusOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof MultiplyOperatorExpression && !multiplyOperatorExpressionVisitors.isEmpty()) {
			for (MultiplyOperatorExpressionVisitor<T, R> visitor : multiplyOperatorExpressionVisitors) {
				if (visitor.appliesTo((MultiplyOperatorExpression) o, context)) {
					return visitor.visit((MultiplyOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof NegativeOperatorExpression && !negativeOperatorExpressionVisitors.isEmpty()) {
			for (NegativeOperatorExpressionVisitor<T, R> visitor : negativeOperatorExpressionVisitors) {
				if (visitor.appliesTo((NegativeOperatorExpression) o, context)) {
					return visitor.visit((NegativeOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof NotEqualsOperatorExpression && !notEqualsOperatorExpressionVisitors.isEmpty()) {
			for (NotEqualsOperatorExpressionVisitor<T, R> visitor : notEqualsOperatorExpressionVisitors) {
				if (visitor.appliesTo((NotEqualsOperatorExpression) o, context)) {
					return visitor.visit((NotEqualsOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof NotOperatorExpression && !notOperatorExpressionVisitors.isEmpty()) {
			for (NotOperatorExpressionVisitor<T, R> visitor : notOperatorExpressionVisitors) {
				if (visitor.appliesTo((NotOperatorExpression) o, context)) {
					return visitor.visit((NotOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof OrOperatorExpression && !orOperatorExpressionVisitors.isEmpty()) {
			for (OrOperatorExpressionVisitor<T, R> visitor : orOperatorExpressionVisitors) {
				if (visitor.appliesTo((OrOperatorExpression) o, context)) {
					return visitor.visit((OrOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof PlusOperatorExpression && !plusOperatorExpressionVisitors.isEmpty()) {
			for (PlusOperatorExpressionVisitor<T, R> visitor : plusOperatorExpressionVisitors) {
				if (visitor.appliesTo((PlusOperatorExpression) o, context)) {
					return visitor.visit((PlusOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof RealExpression && !realExpressionVisitors.isEmpty()) {
			for (RealExpressionVisitor<T, R> visitor : realExpressionVisitors) {
				if (visitor.appliesTo((RealExpression) o, context)) {
					return visitor.visit((RealExpression) o, context, this);
				}
			}
		}
		if (o instanceof StringExpression && !stringExpressionVisitors.isEmpty()) {
			for (StringExpressionVisitor<T, R> visitor : stringExpressionVisitors) {
				if (visitor.appliesTo((StringExpression) o, context)) {
					return visitor.visit((StringExpression) o, context, this);
				}
			}
		}
		if (o instanceof XorOperatorExpression && !xorOperatorExpressionVisitors.isEmpty()) {
			for (XorOperatorExpressionVisitor<T, R> visitor : xorOperatorExpressionVisitors) {
				if (visitor.appliesTo((XorOperatorExpression) o, context)) {
					return visitor.visit((XorOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof SetExpression && !setExpressionVisitors.isEmpty()) {
			for (SetExpressionVisitor<T, R> visitor : setExpressionVisitors) {
				if (visitor.appliesTo((SetExpression) o, context)) {
					return visitor.visit((SetExpression) o, context, this);
				}
			}
		}
		if (o instanceof BagExpression && !bagExpressionVisitors.isEmpty()) {
			for (BagExpressionVisitor<T, R> visitor : bagExpressionVisitors) {
				if (visitor.appliesTo((BagExpression) o, context)) {
					return visitor.visit((BagExpression) o, context, this);
				}
			}
		}
		if (o instanceof SequenceExpression && !sequenceExpressionVisitors.isEmpty()) {
			for (SequenceExpressionVisitor<T, R> visitor : sequenceExpressionVisitors) {
				if (visitor.appliesTo((SequenceExpression) o, context)) {
					return visitor.visit((SequenceExpression) o, context, this);
				}
			}
		}
		if (o instanceof OrderedSetExpression && !orderedSetExpressionVisitors.isEmpty()) {
			for (OrderedSetExpressionVisitor<T, R> visitor : orderedSetExpressionVisitors) {
				if (visitor.appliesTo((OrderedSetExpression) o, context)) {
					return visitor.visit((OrderedSetExpression) o, context, this);
				}
			}
		}
		if (o instanceof SetType && !setTypeVisitors.isEmpty()) {
			for (SetTypeVisitor<T, R> visitor : setTypeVisitors) {
				if (visitor.appliesTo((SetType) o, context)) {
					return visitor.visit((SetType) o, context, this);
				}
			}
		}
		if (o instanceof SequenceType && !sequenceTypeVisitors.isEmpty()) {
			for (SequenceTypeVisitor<T, R> visitor : sequenceTypeVisitors) {
				if (visitor.appliesTo((SequenceType) o, context)) {
					return visitor.visit((SequenceType) o, context, this);
				}
			}
		}
		if (o instanceof BinaryOperatorExpression && !binaryOperatorExpressionVisitors.isEmpty()) {
			for (BinaryOperatorExpressionVisitor<T, R> visitor : binaryOperatorExpressionVisitors) {
				if (visitor.appliesTo((BinaryOperatorExpression) o, context)) {
					return visitor.visit((BinaryOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof MethodCallExpression && !methodCallExpressionVisitors.isEmpty()) {
			for (MethodCallExpressionVisitor<T, R> visitor : methodCallExpressionVisitors) {
				if (visitor.appliesTo((MethodCallExpression) o, context)) {
					return visitor.visit((MethodCallExpression) o, context, this);
				}
			}
		}
		if (o instanceof UnaryOperatorExpression && !unaryOperatorExpressionVisitors.isEmpty()) {
			for (UnaryOperatorExpressionVisitor<T, R> visitor : unaryOperatorExpressionVisitors) {
				if (visitor.appliesTo((UnaryOperatorExpression) o, context)) {
					return visitor.visit((UnaryOperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof PropertyCallExpression && !propertyCallExpressionVisitors.isEmpty()) {
			for (PropertyCallExpressionVisitor<T, R> visitor : propertyCallExpressionVisitors) {
				if (visitor.appliesTo((PropertyCallExpression) o, context)) {
					return visitor.visit((PropertyCallExpression) o, context, this);
				}
			}
		}
		if (o instanceof FOLMethodCallExpression && !fOLMethodCallExpressionVisitors.isEmpty()) {
			for (FOLMethodCallExpressionVisitor<T, R> visitor : fOLMethodCallExpressionVisitors) {
				if (visitor.appliesTo((FOLMethodCallExpression) o, context)) {
					return visitor.visit((FOLMethodCallExpression) o, context, this);
				}
			}
		}
		if (o instanceof SwitchCaseDefaultStatement && !switchCaseDefaultStatementVisitors.isEmpty()) {
			for (SwitchCaseDefaultStatementVisitor<T, R> visitor : switchCaseDefaultStatementVisitors) {
				if (visitor.appliesTo((SwitchCaseDefaultStatement) o, context)) {
					return visitor.visit((SwitchCaseDefaultStatement) o, context, this);
				}
			}
		}
		if (o instanceof SwitchCaseExpressionStatement && !switchCaseExpressionStatementVisitors.isEmpty()) {
			for (SwitchCaseExpressionStatementVisitor<T, R> visitor : switchCaseExpressionStatementVisitors) {
				if (visitor.appliesTo((SwitchCaseExpressionStatement) o, context)) {
					return visitor.visit((SwitchCaseExpressionStatement) o, context, this);
				}
			}
		}
		if (o instanceof PrimitiveExpression && !primitiveExpressionVisitors.isEmpty()) {
			for (PrimitiveExpressionVisitor<T, R> visitor : primitiveExpressionVisitors) {
				if (visitor.appliesTo((PrimitiveExpression) o, context)) {
					return visitor.visit((PrimitiveExpression) o, context, this);
				}
			}
		}
		if (o instanceof CollectionExpression && !collectionExpressionVisitors.isEmpty()) {
			for (CollectionExpressionVisitor<T, R> visitor : collectionExpressionVisitors) {
				if (visitor.appliesTo((CollectionExpression) o, context)) {
					return visitor.visit((CollectionExpression) o, context, this);
				}
			}
		}
		if (o instanceof MapExpression && !mapExpressionVisitors.isEmpty()) {
			for (MapExpressionVisitor<T, R> visitor : mapExpressionVisitors) {
				if (visitor.appliesTo((MapExpression) o, context)) {
					return visitor.visit((MapExpression) o, context, this);
				}
			}
		}
		if (o instanceof BooleanType && !booleanTypeVisitors.isEmpty()) {
			for (BooleanTypeVisitor<T, R> visitor : booleanTypeVisitors) {
				if (visitor.appliesTo((BooleanType) o, context)) {
					return visitor.visit((BooleanType) o, context, this);
				}
			}
		}
		if (o instanceof IntegerType && !integerTypeVisitors.isEmpty()) {
			for (IntegerTypeVisitor<T, R> visitor : integerTypeVisitors) {
				if (visitor.appliesTo((IntegerType) o, context)) {
					return visitor.visit((IntegerType) o, context, this);
				}
			}
		}
		if (o instanceof RealType && !realTypeVisitors.isEmpty()) {
			for (RealTypeVisitor<T, R> visitor : realTypeVisitors) {
				if (visitor.appliesTo((RealType) o, context)) {
					return visitor.visit((RealType) o, context, this);
				}
			}
		}
		if (o instanceof StringType && !stringTypeVisitors.isEmpty()) {
			for (StringTypeVisitor<T, R> visitor : stringTypeVisitors) {
				if (visitor.appliesTo((StringType) o, context)) {
					return visitor.visit((StringType) o, context, this);
				}
			}
		}
		if (o instanceof BagType && !bagTypeVisitors.isEmpty()) {
			for (BagTypeVisitor<T, R> visitor : bagTypeVisitors) {
				if (visitor.appliesTo((BagType) o, context)) {
					return visitor.visit((BagType) o, context, this);
				}
			}
		}
		if (o instanceof SpecialNameExpression && !specialNameExpressionVisitors.isEmpty()) {
			for (SpecialNameExpressionVisitor<T, R> visitor : specialNameExpressionVisitors) {
				if (visitor.appliesTo((SpecialNameExpression) o, context)) {
					return visitor.visit((SpecialNameExpression) o, context, this);
				}
			}
		}
		if (o instanceof ModelExpression && !modelExpressionVisitors.isEmpty()) {
			for (ModelExpressionVisitor<T, R> visitor : modelExpressionVisitors) {
				if (visitor.appliesTo((ModelExpression) o, context)) {
					return visitor.visit((ModelExpression) o, context, this);
				}
			}
		}
		if (o instanceof FormalParameterExpression && !formalParameterExpressionVisitors.isEmpty()) {
			for (FormalParameterExpressionVisitor<T, R> visitor : formalParameterExpressionVisitors) {
				if (visitor.appliesTo((FormalParameterExpression) o, context)) {
					return visitor.visit((FormalParameterExpression) o, context, this);
				}
			}
		}
		if (o instanceof SpecialAssignmentStatement && !specialAssignmentStatementVisitors.isEmpty()) {
			for (SpecialAssignmentStatementVisitor<T, R> visitor : specialAssignmentStatementVisitors) {
				if (visitor.appliesTo((SpecialAssignmentStatement) o, context)) {
					return visitor.visit((SpecialAssignmentStatement) o, context, this);
				}
			}
		}
		if (o instanceof NativeExpression && !nativeExpressionVisitors.isEmpty()) {
			for (NativeExpressionVisitor<T, R> visitor : nativeExpressionVisitors) {
				if (visitor.appliesTo((NativeExpression) o, context)) {
					return visitor.visit((NativeExpression) o, context, this);
				}
			}
		}
		if (o instanceof SelfType && !selfTypeVisitors.isEmpty()) {
			for (SelfTypeVisitor<T, R> visitor : selfTypeVisitors) {
				if (visitor.appliesTo((SelfType) o, context)) {
					return visitor.visit((SelfType) o, context, this);
				}
			}
		}
		if (o instanceof SelfContentType && !selfContentTypeVisitors.isEmpty()) {
			for (SelfContentTypeVisitor<T, R> visitor : selfContentTypeVisitors) {
				if (visitor.appliesTo((SelfContentType) o, context)) {
					return visitor.visit((SelfContentType) o, context, this);
				}
			}
		}
		if (o instanceof OrderedCollectionType && !orderedCollectionTypeVisitors.isEmpty()) {
			for (OrderedCollectionTypeVisitor<T, R> visitor : orderedCollectionTypeVisitors) {
				if (visitor.appliesTo((OrderedCollectionType) o, context)) {
					return visitor.visit((OrderedCollectionType) o, context, this);
				}
			}
		}
		if (o instanceof UniqueCollectionType && !uniqueCollectionTypeVisitors.isEmpty()) {
			for (UniqueCollectionTypeVisitor<T, R> visitor : uniqueCollectionTypeVisitors) {
				if (visitor.appliesTo((UniqueCollectionType) o, context)) {
					return visitor.visit((UniqueCollectionType) o, context, this);
				}
			}
		}
		if (o instanceof SelfInnermostType && !selfInnermostTypeVisitors.isEmpty()) {
			for (SelfInnermostTypeVisitor<T, R> visitor : selfInnermostTypeVisitors) {
				if (visitor.appliesTo((SelfInnermostType) o, context)) {
					return visitor.visit((SelfInnermostType) o, context, this);
				}
			}
		}
		if (o instanceof OperationArgType && !operationArgTypeVisitors.isEmpty()) {
			for (OperationArgTypeVisitor<T, R> visitor : operationArgTypeVisitors) {
				if (visitor.appliesTo((OperationArgType) o, context)) {
					return visitor.visit((OperationArgType) o, context, this);
				}
			}
		}
		if (o instanceof OperatorExpression && !operatorExpressionVisitors.isEmpty()) {
			for (OperatorExpressionVisitor<T, R> visitor : operatorExpressionVisitors) {
				if (visitor.appliesTo((OperatorExpression) o, context)) {
					return visitor.visit((OperatorExpression) o, context, this);
				}
			}
		}
		if (o instanceof LiteralExpression && !literalExpressionVisitors.isEmpty()) {
			for (LiteralExpressionVisitor<T, R> visitor : literalExpressionVisitors) {
				if (visitor.appliesTo((LiteralExpression) o, context)) {
					return visitor.visit((LiteralExpression) o, context, this);
				}
			}
		}
		if (o instanceof EnumerationLiteralExpression && !enumerationLiteralExpressionVisitors.isEmpty()) {
			for (EnumerationLiteralExpressionVisitor<T, R> visitor : enumerationLiteralExpressionVisitors) {
				if (visitor.appliesTo((EnumerationLiteralExpression) o, context)) {
					return visitor.visit((EnumerationLiteralExpression) o, context, this);
				}
			}
		}
		if (o instanceof FeatureCallExpression && !featureCallExpressionVisitors.isEmpty()) {
			for (FeatureCallExpressionVisitor<T, R> visitor : featureCallExpressionVisitors) {
				if (visitor.appliesTo((FeatureCallExpression) o, context)) {
					return visitor.visit((FeatureCallExpression) o, context, this);
				}
			}
		}
		if (o instanceof NameExpression && !nameExpressionVisitors.isEmpty()) {
			for (NameExpressionVisitor<T, R> visitor : nameExpressionVisitors) {
				if (visitor.appliesTo((NameExpression) o, context)) {
					return visitor.visit((NameExpression) o, context, this);
				}
			}
		}
		if (o instanceof VariableDeclarationExpression && !variableDeclarationExpressionVisitors.isEmpty()) {
			for (VariableDeclarationExpressionVisitor<T, R> visitor : variableDeclarationExpressionVisitors) {
				if (visitor.appliesTo((VariableDeclarationExpression) o, context)) {
					return visitor.visit((VariableDeclarationExpression) o, context, this);
				}
			}
		}
		if (o instanceof AssignmentStatement && !assignmentStatementVisitors.isEmpty()) {
			for (AssignmentStatementVisitor<T, R> visitor : assignmentStatementVisitors) {
				if (visitor.appliesTo((AssignmentStatement) o, context)) {
					return visitor.visit((AssignmentStatement) o, context, this);
				}
			}
		}
		if (o instanceof BreakStatement && !breakStatementVisitors.isEmpty()) {
			for (BreakStatementVisitor<T, R> visitor : breakStatementVisitors) {
				if (visitor.appliesTo((BreakStatement) o, context)) {
					return visitor.visit((BreakStatement) o, context, this);
				}
			}
		}
		if (o instanceof BreakAllStatement && !breakAllStatementVisitors.isEmpty()) {
			for (BreakAllStatementVisitor<T, R> visitor : breakAllStatementVisitors) {
				if (visitor.appliesTo((BreakAllStatement) o, context)) {
					return visitor.visit((BreakAllStatement) o, context, this);
				}
			}
		}
		if (o instanceof ContinueStatement && !continueStatementVisitors.isEmpty()) {
			for (ContinueStatementVisitor<T, R> visitor : continueStatementVisitors) {
				if (visitor.appliesTo((ContinueStatement) o, context)) {
					return visitor.visit((ContinueStatement) o, context, this);
				}
			}
		}
		if (o instanceof DeleteStatement && !deleteStatementVisitors.isEmpty()) {
			for (DeleteStatementVisitor<T, R> visitor : deleteStatementVisitors) {
				if (visitor.appliesTo((DeleteStatement) o, context)) {
					return visitor.visit((DeleteStatement) o, context, this);
				}
			}
		}
		if (o instanceof ForStatement && !forStatementVisitors.isEmpty()) {
			for (ForStatementVisitor<T, R> visitor : forStatementVisitors) {
				if (visitor.appliesTo((ForStatement) o, context)) {
					return visitor.visit((ForStatement) o, context, this);
				}
			}
		}
		if (o instanceof IfStatement && !ifStatementVisitors.isEmpty()) {
			for (IfStatementVisitor<T, R> visitor : ifStatementVisitors) {
				if (visitor.appliesTo((IfStatement) o, context)) {
					return visitor.visit((IfStatement) o, context, this);
				}
			}
		}
		if (o instanceof ReturnStatement && !returnStatementVisitors.isEmpty()) {
			for (ReturnStatementVisitor<T, R> visitor : returnStatementVisitors) {
				if (visitor.appliesTo((ReturnStatement) o, context)) {
					return visitor.visit((ReturnStatement) o, context, this);
				}
			}
		}
		if (o instanceof SwitchStatement && !switchStatementVisitors.isEmpty()) {
			for (SwitchStatementVisitor<T, R> visitor : switchStatementVisitors) {
				if (visitor.appliesTo((SwitchStatement) o, context)) {
					return visitor.visit((SwitchStatement) o, context, this);
				}
			}
		}
		if (o instanceof SwitchCaseStatement && !switchCaseStatementVisitors.isEmpty()) {
			for (SwitchCaseStatementVisitor<T, R> visitor : switchCaseStatementVisitors) {
				if (visitor.appliesTo((SwitchCaseStatement) o, context)) {
					return visitor.visit((SwitchCaseStatement) o, context, this);
				}
			}
		}
		if (o instanceof WhileStatement && !whileStatementVisitors.isEmpty()) {
			for (WhileStatementVisitor<T, R> visitor : whileStatementVisitors) {
				if (visitor.appliesTo((WhileStatement) o, context)) {
					return visitor.visit((WhileStatement) o, context, this);
				}
			}
		}
		if (o instanceof ModelDeclarationStatement && !modelDeclarationStatementVisitors.isEmpty()) {
			for (ModelDeclarationStatementVisitor<T, R> visitor : modelDeclarationStatementVisitors) {
				if (visitor.appliesTo((ModelDeclarationStatement) o, context)) {
					return visitor.visit((ModelDeclarationStatement) o, context, this);
				}
			}
		}
		if (o instanceof ExpressionStatement && !expressionStatementVisitors.isEmpty()) {
			for (ExpressionStatementVisitor<T, R> visitor : expressionStatementVisitors) {
				if (visitor.appliesTo((ExpressionStatement) o, context)) {
					return visitor.visit((ExpressionStatement) o, context, this);
				}
			}
		}
		if (o instanceof AnyType && !anyTypeVisitors.isEmpty()) {
			for (AnyTypeVisitor<T, R> visitor : anyTypeVisitors) {
				if (visitor.appliesTo((AnyType) o, context)) {
					return visitor.visit((AnyType) o, context, this);
				}
			}
		}
		if (o instanceof CollectionType && !collectionTypeVisitors.isEmpty()) {
			for (CollectionTypeVisitor<T, R> visitor : collectionTypeVisitors) {
				if (visitor.appliesTo((CollectionType) o, context)) {
					return visitor.visit((CollectionType) o, context, this);
				}
			}
		}
		if (o instanceof PrimitiveType && !primitiveTypeVisitors.isEmpty()) {
			for (PrimitiveTypeVisitor<T, R> visitor : primitiveTypeVisitors) {
				if (visitor.appliesTo((PrimitiveType) o, context)) {
					return visitor.visit((PrimitiveType) o, context, this);
				}
			}
		}
		if (o instanceof MapType && !mapTypeVisitors.isEmpty()) {
			for (MapTypeVisitor<T, R> visitor : mapTypeVisitors) {
				if (visitor.appliesTo((MapType) o, context)) {
					return visitor.visit((MapType) o, context, this);
				}
			}
		}
		if (o instanceof ExecutableAnnotation && !executableAnnotationVisitors.isEmpty()) {
			for (ExecutableAnnotationVisitor<T, R> visitor : executableAnnotationVisitors) {
				if (visitor.appliesTo((ExecutableAnnotation) o, context)) {
					return visitor.visit((ExecutableAnnotation) o, context, this);
				}
			}
		}
		if (o instanceof SimpleAnnotation && !simpleAnnotationVisitors.isEmpty()) {
			for (SimpleAnnotationVisitor<T, R> visitor : simpleAnnotationVisitors) {
				if (visitor.appliesTo((SimpleAnnotation) o, context)) {
					return visitor.visit((SimpleAnnotation) o, context, this);
				}
			}
		}
		if (o instanceof ModelElementType && !modelElementTypeVisitors.isEmpty()) {
			for (ModelElementTypeVisitor<T, R> visitor : modelElementTypeVisitors) {
				if (visitor.appliesTo((ModelElementType) o, context)) {
					return visitor.visit((ModelElementType) o, context, this);
				}
			}
		}
		if (o instanceof NativeType && !nativeTypeVisitors.isEmpty()) {
			for (NativeTypeVisitor<T, R> visitor : nativeTypeVisitors) {
				if (visitor.appliesTo((NativeType) o, context)) {
					return visitor.visit((NativeType) o, context, this);
				}
			}
		}
		if (o instanceof ThrowStatement && !throwStatementVisitors.isEmpty()) {
			for (ThrowStatementVisitor<T, R> visitor : throwStatementVisitors) {
				if (visitor.appliesTo((ThrowStatement) o, context)) {
					return visitor.visit((ThrowStatement) o, context, this);
				}
			}
		}
		if (o instanceof AbortStatement && !abortStatementVisitors.isEmpty()) {
			for (AbortStatementVisitor<T, R> visitor : abortStatementVisitors) {
				if (visitor.appliesTo((AbortStatement) o, context)) {
					return visitor.visit((AbortStatement) o, context, this);
				}
			}
		}
		if (o instanceof TransactionStatement && !transactionStatementVisitors.isEmpty()) {
			for (TransactionStatementVisitor<T, R> visitor : transactionStatementVisitors) {
				if (visitor.appliesTo((TransactionStatement) o, context)) {
					return visitor.visit((TransactionStatement) o, context, this);
				}
			}
		}
		if (o instanceof ExprList && !exprListVisitors.isEmpty()) {
			for (ExprListVisitor<T, R> visitor : exprListVisitors) {
				if (visitor.appliesTo((ExprList) o, context)) {
					return visitor.visit((ExprList) o, context, this);
				}
			}
		}
		if (o instanceof ExpRange && !expRangeVisitors.isEmpty()) {
			for (ExpRangeVisitor<T, R> visitor : expRangeVisitors) {
				if (visitor.appliesTo((ExpRange) o, context)) {
					return visitor.visit((ExpRange) o, context, this);
				}
			}
		}
		if (o instanceof NewExpression && !newExpressionVisitors.isEmpty()) {
			for (NewExpressionVisitor<T, R> visitor : newExpressionVisitors) {
				if (visitor.appliesTo((NewExpression) o, context)) {
					return visitor.visit((NewExpression) o, context, this);
				}
			}
		}
		if (o instanceof ModelType && !modelTypeVisitors.isEmpty()) {
			for (ModelTypeVisitor<T, R> visitor : modelTypeVisitors) {
				if (visitor.appliesTo((ModelType) o, context)) {
					return visitor.visit((ModelType) o, context, this);
				}
			}
		}
		if (o instanceof EType && !eTypeVisitors.isEmpty()) {
			for (ETypeVisitor<T, R> visitor : eTypeVisitors) {
				if (visitor.appliesTo((EType) o, context)) {
					return visitor.visit((EType) o, context, this);
				}
			}
		}
		if (o instanceof VoidType && !voidTypeVisitors.isEmpty()) {
			for (VoidTypeVisitor<T, R> visitor : voidTypeVisitors) {
				if (visitor.appliesTo((VoidType) o, context)) {
					return visitor.visit((VoidType) o, context, this);
				}
			}
		}
		if (o instanceof PseudoType && !pseudoTypeVisitors.isEmpty()) {
			for (PseudoTypeVisitor<T, R> visitor : pseudoTypeVisitors) {
				if (visitor.appliesTo((PseudoType) o, context)) {
					return visitor.visit((PseudoType) o, context, this);
				}
			}
		}
		if (o instanceof Program && !programVisitors.isEmpty()) {
			for (ProgramVisitor<T, R> visitor : programVisitors) {
				if (visitor.appliesTo((Program) o, context)) {
					return visitor.visit((Program) o, context, this);
				}
			}
		}
		if (o instanceof Import && !importVisitors.isEmpty()) {
			for (ImportVisitor<T, R> visitor : importVisitors) {
				if (visitor.appliesTo((Import) o, context)) {
					return visitor.visit((Import) o, context, this);
				}
			}
		}
		if (o instanceof Statement && !statementVisitors.isEmpty()) {
			for (StatementVisitor<T, R> visitor : statementVisitors) {
				if (visitor.appliesTo((Statement) o, context)) {
					return visitor.visit((Statement) o, context, this);
				}
			}
		}
		if (o instanceof Expression && !expressionVisitors.isEmpty()) {
			for (ExpressionVisitor<T, R> visitor : expressionVisitors) {
				if (visitor.appliesTo((Expression) o, context)) {
					return visitor.visit((Expression) o, context, this);
				}
			}
		}
		if (o instanceof Block && !blockVisitors.isEmpty()) {
			for (BlockVisitor<T, R> visitor : blockVisitors) {
				if (visitor.appliesTo((Block) o, context)) {
					return visitor.visit((Block) o, context, this);
				}
			}
		}
		if (o instanceof OperationDefinition && !operationDefinitionVisitors.isEmpty()) {
			for (OperationDefinitionVisitor<T, R> visitor : operationDefinitionVisitors) {
				if (visitor.appliesTo((OperationDefinition) o, context)) {
					return visitor.visit((OperationDefinition) o, context, this);
				}
			}
		}
		if (o instanceof Type && !typeVisitors.isEmpty()) {
			for (TypeVisitor<T, R> visitor : typeVisitors) {
				if (visitor.appliesTo((Type) o, context)) {
					return visitor.visit((Type) o, context, this);
				}
			}
		}
		if (o instanceof Annotation && !annotationVisitors.isEmpty()) {
			for (AnnotationVisitor<T, R> visitor : annotationVisitors) {
				if (visitor.appliesTo((Annotation) o, context)) {
					return visitor.visit((Annotation) o, context, this);
				}
			}
		}
		if (o instanceof KeyValue && !keyValueVisitors.isEmpty()) {
			for (KeyValueVisitor<T, R> visitor : keyValueVisitors) {
				if (visitor.appliesTo((KeyValue) o, context)) {
					return visitor.visit((KeyValue) o, context, this);
				}
			}
		}
		if (o instanceof AnnotationBlock && !annotationBlockVisitors.isEmpty()) {
			for (AnnotationBlockVisitor<T, R> visitor : annotationBlockVisitors) {
				if (visitor.appliesTo((AnnotationBlock) o, context)) {
					return visitor.visit((AnnotationBlock) o, context, this);
				}
			}
		}
		if (o instanceof ModelDeclarationParameter && !modelDeclarationParameterVisitors.isEmpty()) {
			for (ModelDeclarationParameterVisitor<T, R> visitor : modelDeclarationParameterVisitors) {
				if (visitor.appliesTo((ModelDeclarationParameter) o, context)) {
					return visitor.visit((ModelDeclarationParameter) o, context, this);
				}
			}
		}
		if (o instanceof CollectionInitValue && !collectionInitValueVisitors.isEmpty()) {
			for (CollectionInitValueVisitor<T, R> visitor : collectionInitValueVisitors) {
				if (visitor.appliesTo((CollectionInitValue) o, context)) {
					return visitor.visit((CollectionInitValue) o, context, this);
				}
			}
		}
		if (o instanceof EolElement && !eolElementVisitors.isEmpty()) {
			for (EolElementVisitor<T, R> visitor : eolElementVisitors) {
				if (visitor.appliesTo((EolElement) o, context)) {
					return visitor.visit((EolElement) o, context, this);
				}
			}
		}
		if (o instanceof TextRegion && !textRegionVisitors.isEmpty()) {
			for (TextRegionVisitor<T, R> visitor : textRegionVisitors) {
				if (visitor.appliesTo((TextRegion) o, context)) {
					return visitor.visit((TextRegion) o, context, this);
				}
			}
		}
		if (o instanceof TextPosition && !textPositionVisitors.isEmpty()) {
			for (TextPositionVisitor<T, R> visitor : textPositionVisitors) {
				if (visitor.appliesTo((TextPosition) o, context)) {
					return visitor.visit((TextPosition) o, context, this);
				}
			}
		}
		
		for (EolDefaultVisitor<T, R> visitor : defaultVisitors) {
			if (visitor.appliesTo(o, context)) {
				return visitor.visit(o, context, this);
			}
		}
		
		return null;
	}
	
	public void visitContents(EObject o, T context) {
		for (EObject content : o.eContents()) {
			visit(content, context);
		}
	}
	
	public R visitAsOrderedSetType(OrderedSetType orderedSetType, T context) {
		if (!orderedSetTypeVisitors.isEmpty()) {
			for (OrderedSetTypeVisitor<T, R> visitor : orderedSetTypeVisitors) {
				if (visitor.appliesTo((OrderedSetType) orderedSetType, context)) {
					return visitor.visit((OrderedSetType) orderedSetType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsAndOperatorExpression(AndOperatorExpression andOperatorExpression, T context) {
		if (!andOperatorExpressionVisitors.isEmpty()) {
			for (AndOperatorExpressionVisitor<T, R> visitor : andOperatorExpressionVisitors) {
				if (visitor.appliesTo((AndOperatorExpression) andOperatorExpression, context)) {
					return visitor.visit((AndOperatorExpression) andOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsBooleanExpression(BooleanExpression booleanExpression, T context) {
		if (!booleanExpressionVisitors.isEmpty()) {
			for (BooleanExpressionVisitor<T, R> visitor : booleanExpressionVisitors) {
				if (visitor.appliesTo((BooleanExpression) booleanExpression, context)) {
					return visitor.visit((BooleanExpression) booleanExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsDivideOperatorExpression(DivideOperatorExpression divideOperatorExpression, T context) {
		if (!divideOperatorExpressionVisitors.isEmpty()) {
			for (DivideOperatorExpressionVisitor<T, R> visitor : divideOperatorExpressionVisitors) {
				if (visitor.appliesTo((DivideOperatorExpression) divideOperatorExpression, context)) {
					return visitor.visit((DivideOperatorExpression) divideOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsEqualsOperatorExpression(EqualsOperatorExpression equalsOperatorExpression, T context) {
		if (!equalsOperatorExpressionVisitors.isEmpty()) {
			for (EqualsOperatorExpressionVisitor<T, R> visitor : equalsOperatorExpressionVisitors) {
				if (visitor.appliesTo((EqualsOperatorExpression) equalsOperatorExpression, context)) {
					return visitor.visit((EqualsOperatorExpression) equalsOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsGreaterThanOperatorExpression(GreaterThanOperatorExpression greaterThanOperatorExpression, T context) {
		if (!greaterThanOperatorExpressionVisitors.isEmpty()) {
			for (GreaterThanOperatorExpressionVisitor<T, R> visitor : greaterThanOperatorExpressionVisitors) {
				if (visitor.appliesTo((GreaterThanOperatorExpression) greaterThanOperatorExpression, context)) {
					return visitor.visit((GreaterThanOperatorExpression) greaterThanOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsGreaterThanOrEqualToOperatorExpression(GreaterThanOrEqualToOperatorExpression greaterThanOrEqualToOperatorExpression, T context) {
		if (!greaterThanOrEqualToOperatorExpressionVisitors.isEmpty()) {
			for (GreaterThanOrEqualToOperatorExpressionVisitor<T, R> visitor : greaterThanOrEqualToOperatorExpressionVisitors) {
				if (visitor.appliesTo((GreaterThanOrEqualToOperatorExpression) greaterThanOrEqualToOperatorExpression, context)) {
					return visitor.visit((GreaterThanOrEqualToOperatorExpression) greaterThanOrEqualToOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsImpliesOperatorExpression(ImpliesOperatorExpression impliesOperatorExpression, T context) {
		if (!impliesOperatorExpressionVisitors.isEmpty()) {
			for (ImpliesOperatorExpressionVisitor<T, R> visitor : impliesOperatorExpressionVisitors) {
				if (visitor.appliesTo((ImpliesOperatorExpression) impliesOperatorExpression, context)) {
					return visitor.visit((ImpliesOperatorExpression) impliesOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsIntegerExpression(IntegerExpression integerExpression, T context) {
		if (!integerExpressionVisitors.isEmpty()) {
			for (IntegerExpressionVisitor<T, R> visitor : integerExpressionVisitors) {
				if (visitor.appliesTo((IntegerExpression) integerExpression, context)) {
					return visitor.visit((IntegerExpression) integerExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsLessThanOperatorExpression(LessThanOperatorExpression lessThanOperatorExpression, T context) {
		if (!lessThanOperatorExpressionVisitors.isEmpty()) {
			for (LessThanOperatorExpressionVisitor<T, R> visitor : lessThanOperatorExpressionVisitors) {
				if (visitor.appliesTo((LessThanOperatorExpression) lessThanOperatorExpression, context)) {
					return visitor.visit((LessThanOperatorExpression) lessThanOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsLessThanOrEqualToOperatorExpression(LessThanOrEqualToOperatorExpression lessThanOrEqualToOperatorExpression, T context) {
		if (!lessThanOrEqualToOperatorExpressionVisitors.isEmpty()) {
			for (LessThanOrEqualToOperatorExpressionVisitor<T, R> visitor : lessThanOrEqualToOperatorExpressionVisitors) {
				if (visitor.appliesTo((LessThanOrEqualToOperatorExpression) lessThanOrEqualToOperatorExpression, context)) {
					return visitor.visit((LessThanOrEqualToOperatorExpression) lessThanOrEqualToOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsMinusOperatorExpression(MinusOperatorExpression minusOperatorExpression, T context) {
		if (!minusOperatorExpressionVisitors.isEmpty()) {
			for (MinusOperatorExpressionVisitor<T, R> visitor : minusOperatorExpressionVisitors) {
				if (visitor.appliesTo((MinusOperatorExpression) minusOperatorExpression, context)) {
					return visitor.visit((MinusOperatorExpression) minusOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsMultiplyOperatorExpression(MultiplyOperatorExpression multiplyOperatorExpression, T context) {
		if (!multiplyOperatorExpressionVisitors.isEmpty()) {
			for (MultiplyOperatorExpressionVisitor<T, R> visitor : multiplyOperatorExpressionVisitors) {
				if (visitor.appliesTo((MultiplyOperatorExpression) multiplyOperatorExpression, context)) {
					return visitor.visit((MultiplyOperatorExpression) multiplyOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsNegativeOperatorExpression(NegativeOperatorExpression negativeOperatorExpression, T context) {
		if (!negativeOperatorExpressionVisitors.isEmpty()) {
			for (NegativeOperatorExpressionVisitor<T, R> visitor : negativeOperatorExpressionVisitors) {
				if (visitor.appliesTo((NegativeOperatorExpression) negativeOperatorExpression, context)) {
					return visitor.visit((NegativeOperatorExpression) negativeOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsNotEqualsOperatorExpression(NotEqualsOperatorExpression notEqualsOperatorExpression, T context) {
		if (!notEqualsOperatorExpressionVisitors.isEmpty()) {
			for (NotEqualsOperatorExpressionVisitor<T, R> visitor : notEqualsOperatorExpressionVisitors) {
				if (visitor.appliesTo((NotEqualsOperatorExpression) notEqualsOperatorExpression, context)) {
					return visitor.visit((NotEqualsOperatorExpression) notEqualsOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsNotOperatorExpression(NotOperatorExpression notOperatorExpression, T context) {
		if (!notOperatorExpressionVisitors.isEmpty()) {
			for (NotOperatorExpressionVisitor<T, R> visitor : notOperatorExpressionVisitors) {
				if (visitor.appliesTo((NotOperatorExpression) notOperatorExpression, context)) {
					return visitor.visit((NotOperatorExpression) notOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsOrOperatorExpression(OrOperatorExpression orOperatorExpression, T context) {
		if (!orOperatorExpressionVisitors.isEmpty()) {
			for (OrOperatorExpressionVisitor<T, R> visitor : orOperatorExpressionVisitors) {
				if (visitor.appliesTo((OrOperatorExpression) orOperatorExpression, context)) {
					return visitor.visit((OrOperatorExpression) orOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsPlusOperatorExpression(PlusOperatorExpression plusOperatorExpression, T context) {
		if (!plusOperatorExpressionVisitors.isEmpty()) {
			for (PlusOperatorExpressionVisitor<T, R> visitor : plusOperatorExpressionVisitors) {
				if (visitor.appliesTo((PlusOperatorExpression) plusOperatorExpression, context)) {
					return visitor.visit((PlusOperatorExpression) plusOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsRealExpression(RealExpression realExpression, T context) {
		if (!realExpressionVisitors.isEmpty()) {
			for (RealExpressionVisitor<T, R> visitor : realExpressionVisitors) {
				if (visitor.appliesTo((RealExpression) realExpression, context)) {
					return visitor.visit((RealExpression) realExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsStringExpression(StringExpression stringExpression, T context) {
		if (!stringExpressionVisitors.isEmpty()) {
			for (StringExpressionVisitor<T, R> visitor : stringExpressionVisitors) {
				if (visitor.appliesTo((StringExpression) stringExpression, context)) {
					return visitor.visit((StringExpression) stringExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsXorOperatorExpression(XorOperatorExpression xorOperatorExpression, T context) {
		if (!xorOperatorExpressionVisitors.isEmpty()) {
			for (XorOperatorExpressionVisitor<T, R> visitor : xorOperatorExpressionVisitors) {
				if (visitor.appliesTo((XorOperatorExpression) xorOperatorExpression, context)) {
					return visitor.visit((XorOperatorExpression) xorOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsSetExpression(SetExpression setExpression, T context) {
		if (!setExpressionVisitors.isEmpty()) {
			for (SetExpressionVisitor<T, R> visitor : setExpressionVisitors) {
				if (visitor.appliesTo((SetExpression) setExpression, context)) {
					return visitor.visit((SetExpression) setExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsBagExpression(BagExpression bagExpression, T context) {
		if (!bagExpressionVisitors.isEmpty()) {
			for (BagExpressionVisitor<T, R> visitor : bagExpressionVisitors) {
				if (visitor.appliesTo((BagExpression) bagExpression, context)) {
					return visitor.visit((BagExpression) bagExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsSequenceExpression(SequenceExpression sequenceExpression, T context) {
		if (!sequenceExpressionVisitors.isEmpty()) {
			for (SequenceExpressionVisitor<T, R> visitor : sequenceExpressionVisitors) {
				if (visitor.appliesTo((SequenceExpression) sequenceExpression, context)) {
					return visitor.visit((SequenceExpression) sequenceExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsOrderedSetExpression(OrderedSetExpression orderedSetExpression, T context) {
		if (!orderedSetExpressionVisitors.isEmpty()) {
			for (OrderedSetExpressionVisitor<T, R> visitor : orderedSetExpressionVisitors) {
				if (visitor.appliesTo((OrderedSetExpression) orderedSetExpression, context)) {
					return visitor.visit((OrderedSetExpression) orderedSetExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsSetType(SetType setType, T context) {
		if (!setTypeVisitors.isEmpty()) {
			for (SetTypeVisitor<T, R> visitor : setTypeVisitors) {
				if (visitor.appliesTo((SetType) setType, context)) {
					return visitor.visit((SetType) setType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsSequenceType(SequenceType sequenceType, T context) {
		if (!sequenceTypeVisitors.isEmpty()) {
			for (SequenceTypeVisitor<T, R> visitor : sequenceTypeVisitors) {
				if (visitor.appliesTo((SequenceType) sequenceType, context)) {
					return visitor.visit((SequenceType) sequenceType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsBinaryOperatorExpression(BinaryOperatorExpression binaryOperatorExpression, T context) {
		if (!binaryOperatorExpressionVisitors.isEmpty()) {
			for (BinaryOperatorExpressionVisitor<T, R> visitor : binaryOperatorExpressionVisitors) {
				if (visitor.appliesTo((BinaryOperatorExpression) binaryOperatorExpression, context)) {
					return visitor.visit((BinaryOperatorExpression) binaryOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsMethodCallExpression(MethodCallExpression methodCallExpression, T context) {
		if (!methodCallExpressionVisitors.isEmpty()) {
			for (MethodCallExpressionVisitor<T, R> visitor : methodCallExpressionVisitors) {
				if (visitor.appliesTo((MethodCallExpression) methodCallExpression, context)) {
					return visitor.visit((MethodCallExpression) methodCallExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsUnaryOperatorExpression(UnaryOperatorExpression unaryOperatorExpression, T context) {
		if (!unaryOperatorExpressionVisitors.isEmpty()) {
			for (UnaryOperatorExpressionVisitor<T, R> visitor : unaryOperatorExpressionVisitors) {
				if (visitor.appliesTo((UnaryOperatorExpression) unaryOperatorExpression, context)) {
					return visitor.visit((UnaryOperatorExpression) unaryOperatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsPropertyCallExpression(PropertyCallExpression propertyCallExpression, T context) {
		if (!propertyCallExpressionVisitors.isEmpty()) {
			for (PropertyCallExpressionVisitor<T, R> visitor : propertyCallExpressionVisitors) {
				if (visitor.appliesTo((PropertyCallExpression) propertyCallExpression, context)) {
					return visitor.visit((PropertyCallExpression) propertyCallExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsFOLMethodCallExpression(FOLMethodCallExpression fOLMethodCallExpression, T context) {
		if (!fOLMethodCallExpressionVisitors.isEmpty()) {
			for (FOLMethodCallExpressionVisitor<T, R> visitor : fOLMethodCallExpressionVisitors) {
				if (visitor.appliesTo((FOLMethodCallExpression) fOLMethodCallExpression, context)) {
					return visitor.visit((FOLMethodCallExpression) fOLMethodCallExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsSwitchCaseDefaultStatement(SwitchCaseDefaultStatement switchCaseDefaultStatement, T context) {
		if (!switchCaseDefaultStatementVisitors.isEmpty()) {
			for (SwitchCaseDefaultStatementVisitor<T, R> visitor : switchCaseDefaultStatementVisitors) {
				if (visitor.appliesTo((SwitchCaseDefaultStatement) switchCaseDefaultStatement, context)) {
					return visitor.visit((SwitchCaseDefaultStatement) switchCaseDefaultStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsSwitchCaseExpressionStatement(SwitchCaseExpressionStatement switchCaseExpressionStatement, T context) {
		if (!switchCaseExpressionStatementVisitors.isEmpty()) {
			for (SwitchCaseExpressionStatementVisitor<T, R> visitor : switchCaseExpressionStatementVisitors) {
				if (visitor.appliesTo((SwitchCaseExpressionStatement) switchCaseExpressionStatement, context)) {
					return visitor.visit((SwitchCaseExpressionStatement) switchCaseExpressionStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsPrimitiveExpression(PrimitiveExpression primitiveExpression, T context) {
		if (!primitiveExpressionVisitors.isEmpty()) {
			for (PrimitiveExpressionVisitor<T, R> visitor : primitiveExpressionVisitors) {
				if (visitor.appliesTo((PrimitiveExpression) primitiveExpression, context)) {
					return visitor.visit((PrimitiveExpression) primitiveExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsCollectionExpression(CollectionExpression collectionExpression, T context) {
		if (!collectionExpressionVisitors.isEmpty()) {
			for (CollectionExpressionVisitor<T, R> visitor : collectionExpressionVisitors) {
				if (visitor.appliesTo((CollectionExpression) collectionExpression, context)) {
					return visitor.visit((CollectionExpression) collectionExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsMapExpression(MapExpression mapExpression, T context) {
		if (!mapExpressionVisitors.isEmpty()) {
			for (MapExpressionVisitor<T, R> visitor : mapExpressionVisitors) {
				if (visitor.appliesTo((MapExpression) mapExpression, context)) {
					return visitor.visit((MapExpression) mapExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsBooleanType(BooleanType booleanType, T context) {
		if (!booleanTypeVisitors.isEmpty()) {
			for (BooleanTypeVisitor<T, R> visitor : booleanTypeVisitors) {
				if (visitor.appliesTo((BooleanType) booleanType, context)) {
					return visitor.visit((BooleanType) booleanType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsIntegerType(IntegerType integerType, T context) {
		if (!integerTypeVisitors.isEmpty()) {
			for (IntegerTypeVisitor<T, R> visitor : integerTypeVisitors) {
				if (visitor.appliesTo((IntegerType) integerType, context)) {
					return visitor.visit((IntegerType) integerType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsRealType(RealType realType, T context) {
		if (!realTypeVisitors.isEmpty()) {
			for (RealTypeVisitor<T, R> visitor : realTypeVisitors) {
				if (visitor.appliesTo((RealType) realType, context)) {
					return visitor.visit((RealType) realType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsStringType(StringType stringType, T context) {
		if (!stringTypeVisitors.isEmpty()) {
			for (StringTypeVisitor<T, R> visitor : stringTypeVisitors) {
				if (visitor.appliesTo((StringType) stringType, context)) {
					return visitor.visit((StringType) stringType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsBagType(BagType bagType, T context) {
		if (!bagTypeVisitors.isEmpty()) {
			for (BagTypeVisitor<T, R> visitor : bagTypeVisitors) {
				if (visitor.appliesTo((BagType) bagType, context)) {
					return visitor.visit((BagType) bagType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsSpecialNameExpression(SpecialNameExpression specialNameExpression, T context) {
		if (!specialNameExpressionVisitors.isEmpty()) {
			for (SpecialNameExpressionVisitor<T, R> visitor : specialNameExpressionVisitors) {
				if (visitor.appliesTo((SpecialNameExpression) specialNameExpression, context)) {
					return visitor.visit((SpecialNameExpression) specialNameExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsModelExpression(ModelExpression modelExpression, T context) {
		if (!modelExpressionVisitors.isEmpty()) {
			for (ModelExpressionVisitor<T, R> visitor : modelExpressionVisitors) {
				if (visitor.appliesTo((ModelExpression) modelExpression, context)) {
					return visitor.visit((ModelExpression) modelExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsFormalParameterExpression(FormalParameterExpression formalParameterExpression, T context) {
		if (!formalParameterExpressionVisitors.isEmpty()) {
			for (FormalParameterExpressionVisitor<T, R> visitor : formalParameterExpressionVisitors) {
				if (visitor.appliesTo((FormalParameterExpression) formalParameterExpression, context)) {
					return visitor.visit((FormalParameterExpression) formalParameterExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsSpecialAssignmentStatement(SpecialAssignmentStatement specialAssignmentStatement, T context) {
		if (!specialAssignmentStatementVisitors.isEmpty()) {
			for (SpecialAssignmentStatementVisitor<T, R> visitor : specialAssignmentStatementVisitors) {
				if (visitor.appliesTo((SpecialAssignmentStatement) specialAssignmentStatement, context)) {
					return visitor.visit((SpecialAssignmentStatement) specialAssignmentStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsNativeExpression(NativeExpression nativeExpression, T context) {
		if (!nativeExpressionVisitors.isEmpty()) {
			for (NativeExpressionVisitor<T, R> visitor : nativeExpressionVisitors) {
				if (visitor.appliesTo((NativeExpression) nativeExpression, context)) {
					return visitor.visit((NativeExpression) nativeExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsSelfType(SelfType selfType, T context) {
		if (!selfTypeVisitors.isEmpty()) {
			for (SelfTypeVisitor<T, R> visitor : selfTypeVisitors) {
				if (visitor.appliesTo((SelfType) selfType, context)) {
					return visitor.visit((SelfType) selfType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsSelfContentType(SelfContentType selfContentType, T context) {
		if (!selfContentTypeVisitors.isEmpty()) {
			for (SelfContentTypeVisitor<T, R> visitor : selfContentTypeVisitors) {
				if (visitor.appliesTo((SelfContentType) selfContentType, context)) {
					return visitor.visit((SelfContentType) selfContentType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsOrderedCollectionType(OrderedCollectionType orderedCollectionType, T context) {
		if (!orderedCollectionTypeVisitors.isEmpty()) {
			for (OrderedCollectionTypeVisitor<T, R> visitor : orderedCollectionTypeVisitors) {
				if (visitor.appliesTo((OrderedCollectionType) orderedCollectionType, context)) {
					return visitor.visit((OrderedCollectionType) orderedCollectionType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsUniqueCollectionType(UniqueCollectionType uniqueCollectionType, T context) {
		if (!uniqueCollectionTypeVisitors.isEmpty()) {
			for (UniqueCollectionTypeVisitor<T, R> visitor : uniqueCollectionTypeVisitors) {
				if (visitor.appliesTo((UniqueCollectionType) uniqueCollectionType, context)) {
					return visitor.visit((UniqueCollectionType) uniqueCollectionType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsSelfInnermostType(SelfInnermostType selfInnermostType, T context) {
		if (!selfInnermostTypeVisitors.isEmpty()) {
			for (SelfInnermostTypeVisitor<T, R> visitor : selfInnermostTypeVisitors) {
				if (visitor.appliesTo((SelfInnermostType) selfInnermostType, context)) {
					return visitor.visit((SelfInnermostType) selfInnermostType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsOperationArgType(OperationArgType operationArgType, T context) {
		if (!operationArgTypeVisitors.isEmpty()) {
			for (OperationArgTypeVisitor<T, R> visitor : operationArgTypeVisitors) {
				if (visitor.appliesTo((OperationArgType) operationArgType, context)) {
					return visitor.visit((OperationArgType) operationArgType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsOperatorExpression(OperatorExpression operatorExpression, T context) {
		if (!operatorExpressionVisitors.isEmpty()) {
			for (OperatorExpressionVisitor<T, R> visitor : operatorExpressionVisitors) {
				if (visitor.appliesTo((OperatorExpression) operatorExpression, context)) {
					return visitor.visit((OperatorExpression) operatorExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsLiteralExpression(LiteralExpression literalExpression, T context) {
		if (!literalExpressionVisitors.isEmpty()) {
			for (LiteralExpressionVisitor<T, R> visitor : literalExpressionVisitors) {
				if (visitor.appliesTo((LiteralExpression) literalExpression, context)) {
					return visitor.visit((LiteralExpression) literalExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsEnumerationLiteralExpression(EnumerationLiteralExpression enumerationLiteralExpression, T context) {
		if (!enumerationLiteralExpressionVisitors.isEmpty()) {
			for (EnumerationLiteralExpressionVisitor<T, R> visitor : enumerationLiteralExpressionVisitors) {
				if (visitor.appliesTo((EnumerationLiteralExpression) enumerationLiteralExpression, context)) {
					return visitor.visit((EnumerationLiteralExpression) enumerationLiteralExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsFeatureCallExpression(FeatureCallExpression featureCallExpression, T context) {
		if (!featureCallExpressionVisitors.isEmpty()) {
			for (FeatureCallExpressionVisitor<T, R> visitor : featureCallExpressionVisitors) {
				if (visitor.appliesTo((FeatureCallExpression) featureCallExpression, context)) {
					return visitor.visit((FeatureCallExpression) featureCallExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsNameExpression(NameExpression nameExpression, T context) {
		if (!nameExpressionVisitors.isEmpty()) {
			for (NameExpressionVisitor<T, R> visitor : nameExpressionVisitors) {
				if (visitor.appliesTo((NameExpression) nameExpression, context)) {
					return visitor.visit((NameExpression) nameExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsVariableDeclarationExpression(VariableDeclarationExpression variableDeclarationExpression, T context) {
		if (!variableDeclarationExpressionVisitors.isEmpty()) {
			for (VariableDeclarationExpressionVisitor<T, R> visitor : variableDeclarationExpressionVisitors) {
				if (visitor.appliesTo((VariableDeclarationExpression) variableDeclarationExpression, context)) {
					return visitor.visit((VariableDeclarationExpression) variableDeclarationExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsAssignmentStatement(AssignmentStatement assignmentStatement, T context) {
		if (!assignmentStatementVisitors.isEmpty()) {
			for (AssignmentStatementVisitor<T, R> visitor : assignmentStatementVisitors) {
				if (visitor.appliesTo((AssignmentStatement) assignmentStatement, context)) {
					return visitor.visit((AssignmentStatement) assignmentStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsBreakStatement(BreakStatement breakStatement, T context) {
		if (!breakStatementVisitors.isEmpty()) {
			for (BreakStatementVisitor<T, R> visitor : breakStatementVisitors) {
				if (visitor.appliesTo((BreakStatement) breakStatement, context)) {
					return visitor.visit((BreakStatement) breakStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsBreakAllStatement(BreakAllStatement breakAllStatement, T context) {
		if (!breakAllStatementVisitors.isEmpty()) {
			for (BreakAllStatementVisitor<T, R> visitor : breakAllStatementVisitors) {
				if (visitor.appliesTo((BreakAllStatement) breakAllStatement, context)) {
					return visitor.visit((BreakAllStatement) breakAllStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsContinueStatement(ContinueStatement continueStatement, T context) {
		if (!continueStatementVisitors.isEmpty()) {
			for (ContinueStatementVisitor<T, R> visitor : continueStatementVisitors) {
				if (visitor.appliesTo((ContinueStatement) continueStatement, context)) {
					return visitor.visit((ContinueStatement) continueStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsDeleteStatement(DeleteStatement deleteStatement, T context) {
		if (!deleteStatementVisitors.isEmpty()) {
			for (DeleteStatementVisitor<T, R> visitor : deleteStatementVisitors) {
				if (visitor.appliesTo((DeleteStatement) deleteStatement, context)) {
					return visitor.visit((DeleteStatement) deleteStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsForStatement(ForStatement forStatement, T context) {
		if (!forStatementVisitors.isEmpty()) {
			for (ForStatementVisitor<T, R> visitor : forStatementVisitors) {
				if (visitor.appliesTo((ForStatement) forStatement, context)) {
					return visitor.visit((ForStatement) forStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsIfStatement(IfStatement ifStatement, T context) {
		if (!ifStatementVisitors.isEmpty()) {
			for (IfStatementVisitor<T, R> visitor : ifStatementVisitors) {
				if (visitor.appliesTo((IfStatement) ifStatement, context)) {
					return visitor.visit((IfStatement) ifStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsReturnStatement(ReturnStatement returnStatement, T context) {
		if (!returnStatementVisitors.isEmpty()) {
			for (ReturnStatementVisitor<T, R> visitor : returnStatementVisitors) {
				if (visitor.appliesTo((ReturnStatement) returnStatement, context)) {
					return visitor.visit((ReturnStatement) returnStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsSwitchStatement(SwitchStatement switchStatement, T context) {
		if (!switchStatementVisitors.isEmpty()) {
			for (SwitchStatementVisitor<T, R> visitor : switchStatementVisitors) {
				if (visitor.appliesTo((SwitchStatement) switchStatement, context)) {
					return visitor.visit((SwitchStatement) switchStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsSwitchCaseStatement(SwitchCaseStatement switchCaseStatement, T context) {
		if (!switchCaseStatementVisitors.isEmpty()) {
			for (SwitchCaseStatementVisitor<T, R> visitor : switchCaseStatementVisitors) {
				if (visitor.appliesTo((SwitchCaseStatement) switchCaseStatement, context)) {
					return visitor.visit((SwitchCaseStatement) switchCaseStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsWhileStatement(WhileStatement whileStatement, T context) {
		if (!whileStatementVisitors.isEmpty()) {
			for (WhileStatementVisitor<T, R> visitor : whileStatementVisitors) {
				if (visitor.appliesTo((WhileStatement) whileStatement, context)) {
					return visitor.visit((WhileStatement) whileStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsModelDeclarationStatement(ModelDeclarationStatement modelDeclarationStatement, T context) {
		if (!modelDeclarationStatementVisitors.isEmpty()) {
			for (ModelDeclarationStatementVisitor<T, R> visitor : modelDeclarationStatementVisitors) {
				if (visitor.appliesTo((ModelDeclarationStatement) modelDeclarationStatement, context)) {
					return visitor.visit((ModelDeclarationStatement) modelDeclarationStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsExpressionStatement(ExpressionStatement expressionStatement, T context) {
		if (!expressionStatementVisitors.isEmpty()) {
			for (ExpressionStatementVisitor<T, R> visitor : expressionStatementVisitors) {
				if (visitor.appliesTo((ExpressionStatement) expressionStatement, context)) {
					return visitor.visit((ExpressionStatement) expressionStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsAnyType(AnyType anyType, T context) {
		if (!anyTypeVisitors.isEmpty()) {
			for (AnyTypeVisitor<T, R> visitor : anyTypeVisitors) {
				if (visitor.appliesTo((AnyType) anyType, context)) {
					return visitor.visit((AnyType) anyType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsCollectionType(CollectionType collectionType, T context) {
		if (!collectionTypeVisitors.isEmpty()) {
			for (CollectionTypeVisitor<T, R> visitor : collectionTypeVisitors) {
				if (visitor.appliesTo((CollectionType) collectionType, context)) {
					return visitor.visit((CollectionType) collectionType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsPrimitiveType(PrimitiveType primitiveType, T context) {
		if (!primitiveTypeVisitors.isEmpty()) {
			for (PrimitiveTypeVisitor<T, R> visitor : primitiveTypeVisitors) {
				if (visitor.appliesTo((PrimitiveType) primitiveType, context)) {
					return visitor.visit((PrimitiveType) primitiveType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsMapType(MapType mapType, T context) {
		if (!mapTypeVisitors.isEmpty()) {
			for (MapTypeVisitor<T, R> visitor : mapTypeVisitors) {
				if (visitor.appliesTo((MapType) mapType, context)) {
					return visitor.visit((MapType) mapType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsExecutableAnnotation(ExecutableAnnotation executableAnnotation, T context) {
		if (!executableAnnotationVisitors.isEmpty()) {
			for (ExecutableAnnotationVisitor<T, R> visitor : executableAnnotationVisitors) {
				if (visitor.appliesTo((ExecutableAnnotation) executableAnnotation, context)) {
					return visitor.visit((ExecutableAnnotation) executableAnnotation, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsSimpleAnnotation(SimpleAnnotation simpleAnnotation, T context) {
		if (!simpleAnnotationVisitors.isEmpty()) {
			for (SimpleAnnotationVisitor<T, R> visitor : simpleAnnotationVisitors) {
				if (visitor.appliesTo((SimpleAnnotation) simpleAnnotation, context)) {
					return visitor.visit((SimpleAnnotation) simpleAnnotation, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsModelElementType(ModelElementType modelElementType, T context) {
		if (!modelElementTypeVisitors.isEmpty()) {
			for (ModelElementTypeVisitor<T, R> visitor : modelElementTypeVisitors) {
				if (visitor.appliesTo((ModelElementType) modelElementType, context)) {
					return visitor.visit((ModelElementType) modelElementType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsNativeType(NativeType nativeType, T context) {
		if (!nativeTypeVisitors.isEmpty()) {
			for (NativeTypeVisitor<T, R> visitor : nativeTypeVisitors) {
				if (visitor.appliesTo((NativeType) nativeType, context)) {
					return visitor.visit((NativeType) nativeType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsThrowStatement(ThrowStatement throwStatement, T context) {
		if (!throwStatementVisitors.isEmpty()) {
			for (ThrowStatementVisitor<T, R> visitor : throwStatementVisitors) {
				if (visitor.appliesTo((ThrowStatement) throwStatement, context)) {
					return visitor.visit((ThrowStatement) throwStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsAbortStatement(AbortStatement abortStatement, T context) {
		if (!abortStatementVisitors.isEmpty()) {
			for (AbortStatementVisitor<T, R> visitor : abortStatementVisitors) {
				if (visitor.appliesTo((AbortStatement) abortStatement, context)) {
					return visitor.visit((AbortStatement) abortStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsTransactionStatement(TransactionStatement transactionStatement, T context) {
		if (!transactionStatementVisitors.isEmpty()) {
			for (TransactionStatementVisitor<T, R> visitor : transactionStatementVisitors) {
				if (visitor.appliesTo((TransactionStatement) transactionStatement, context)) {
					return visitor.visit((TransactionStatement) transactionStatement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsExprList(ExprList exprList, T context) {
		if (!exprListVisitors.isEmpty()) {
			for (ExprListVisitor<T, R> visitor : exprListVisitors) {
				if (visitor.appliesTo((ExprList) exprList, context)) {
					return visitor.visit((ExprList) exprList, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsExpRange(ExpRange expRange, T context) {
		if (!expRangeVisitors.isEmpty()) {
			for (ExpRangeVisitor<T, R> visitor : expRangeVisitors) {
				if (visitor.appliesTo((ExpRange) expRange, context)) {
					return visitor.visit((ExpRange) expRange, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsNewExpression(NewExpression newExpression, T context) {
		if (!newExpressionVisitors.isEmpty()) {
			for (NewExpressionVisitor<T, R> visitor : newExpressionVisitors) {
				if (visitor.appliesTo((NewExpression) newExpression, context)) {
					return visitor.visit((NewExpression) newExpression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsModelType(ModelType modelType, T context) {
		if (!modelTypeVisitors.isEmpty()) {
			for (ModelTypeVisitor<T, R> visitor : modelTypeVisitors) {
				if (visitor.appliesTo((ModelType) modelType, context)) {
					return visitor.visit((ModelType) modelType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsEType(EType eType, T context) {
		if (!eTypeVisitors.isEmpty()) {
			for (ETypeVisitor<T, R> visitor : eTypeVisitors) {
				if (visitor.appliesTo((EType) eType, context)) {
					return visitor.visit((EType) eType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsVoidType(VoidType voidType, T context) {
		if (!voidTypeVisitors.isEmpty()) {
			for (VoidTypeVisitor<T, R> visitor : voidTypeVisitors) {
				if (visitor.appliesTo((VoidType) voidType, context)) {
					return visitor.visit((VoidType) voidType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsPseudoType(PseudoType pseudoType, T context) {
		if (!pseudoTypeVisitors.isEmpty()) {
			for (PseudoTypeVisitor<T, R> visitor : pseudoTypeVisitors) {
				if (visitor.appliesTo((PseudoType) pseudoType, context)) {
					return visitor.visit((PseudoType) pseudoType, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsProgram(Program program, T context) {
		if (!programVisitors.isEmpty()) {
			for (ProgramVisitor<T, R> visitor : programVisitors) {
				if (visitor.appliesTo((Program) program, context)) {
					return visitor.visit((Program) program, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsImport(Import _import, T context) {
		if (!importVisitors.isEmpty()) {
			for (ImportVisitor<T, R> visitor : importVisitors) {
				if (visitor.appliesTo((Import) _import, context)) {
					return visitor.visit((Import) _import, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsStatement(Statement statement, T context) {
		if (!statementVisitors.isEmpty()) {
			for (StatementVisitor<T, R> visitor : statementVisitors) {
				if (visitor.appliesTo((Statement) statement, context)) {
					return visitor.visit((Statement) statement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsExpression(Expression expression, T context) {
		if (!expressionVisitors.isEmpty()) {
			for (ExpressionVisitor<T, R> visitor : expressionVisitors) {
				if (visitor.appliesTo((Expression) expression, context)) {
					return visitor.visit((Expression) expression, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsBlock(Block block, T context) {
		if (!blockVisitors.isEmpty()) {
			for (BlockVisitor<T, R> visitor : blockVisitors) {
				if (visitor.appliesTo((Block) block, context)) {
					return visitor.visit((Block) block, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsOperationDefinition(OperationDefinition operationDefinition, T context) {
		if (!operationDefinitionVisitors.isEmpty()) {
			for (OperationDefinitionVisitor<T, R> visitor : operationDefinitionVisitors) {
				if (visitor.appliesTo((OperationDefinition) operationDefinition, context)) {
					return visitor.visit((OperationDefinition) operationDefinition, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsType(Type type, T context) {
		if (!typeVisitors.isEmpty()) {
			for (TypeVisitor<T, R> visitor : typeVisitors) {
				if (visitor.appliesTo((Type) type, context)) {
					return visitor.visit((Type) type, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsAnnotation(Annotation annotation, T context) {
		if (!annotationVisitors.isEmpty()) {
			for (AnnotationVisitor<T, R> visitor : annotationVisitors) {
				if (visitor.appliesTo((Annotation) annotation, context)) {
					return visitor.visit((Annotation) annotation, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsKeyValue(KeyValue keyValue, T context) {
		if (!keyValueVisitors.isEmpty()) {
			for (KeyValueVisitor<T, R> visitor : keyValueVisitors) {
				if (visitor.appliesTo((KeyValue) keyValue, context)) {
					return visitor.visit((KeyValue) keyValue, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsAnnotationBlock(AnnotationBlock annotationBlock, T context) {
		if (!annotationBlockVisitors.isEmpty()) {
			for (AnnotationBlockVisitor<T, R> visitor : annotationBlockVisitors) {
				if (visitor.appliesTo((AnnotationBlock) annotationBlock, context)) {
					return visitor.visit((AnnotationBlock) annotationBlock, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsModelDeclarationParameter(ModelDeclarationParameter modelDeclarationParameter, T context) {
		if (!modelDeclarationParameterVisitors.isEmpty()) {
			for (ModelDeclarationParameterVisitor<T, R> visitor : modelDeclarationParameterVisitors) {
				if (visitor.appliesTo((ModelDeclarationParameter) modelDeclarationParameter, context)) {
					return visitor.visit((ModelDeclarationParameter) modelDeclarationParameter, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsCollectionInitValue(CollectionInitValue collectionInitValue, T context) {
		if (!collectionInitValueVisitors.isEmpty()) {
			for (CollectionInitValueVisitor<T, R> visitor : collectionInitValueVisitors) {
				if (visitor.appliesTo((CollectionInitValue) collectionInitValue, context)) {
					return visitor.visit((CollectionInitValue) collectionInitValue, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsEolElement(EolElement eolElement, T context) {
		if (!eolElementVisitors.isEmpty()) {
			for (EolElementVisitor<T, R> visitor : eolElementVisitors) {
				if (visitor.appliesTo((EolElement) eolElement, context)) {
					return visitor.visit((EolElement) eolElement, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsTextRegion(TextRegion textRegion, T context) {
		if (!textRegionVisitors.isEmpty()) {
			for (TextRegionVisitor<T, R> visitor : textRegionVisitors) {
				if (visitor.appliesTo((TextRegion) textRegion, context)) {
					return visitor.visit((TextRegion) textRegion, context, this);
				}
			}
		}
		return null;
	}
	public R visitAsTextPosition(TextPosition textPosition, T context) {
		if (!textPositionVisitors.isEmpty()) {
			for (TextPositionVisitor<T, R> visitor : textPositionVisitors) {
				if (visitor.appliesTo((TextPosition) textPosition, context)) {
					return visitor.visit((TextPosition) textPosition, context, this);
				}
			}
		}
		return null;
	}
	
	public boolean addOrderedSetTypeVisitor(OrderedSetTypeVisitor<T, R> orderedSetTypeVisitor) {
		return this.orderedSetTypeVisitors.add(orderedSetTypeVisitor);
	}
	
	public boolean addAndOperatorExpressionVisitor(AndOperatorExpressionVisitor<T, R> andOperatorExpressionVisitor) {
		return this.andOperatorExpressionVisitors.add(andOperatorExpressionVisitor);
	}
	
	public boolean addBooleanExpressionVisitor(BooleanExpressionVisitor<T, R> booleanExpressionVisitor) {
		return this.booleanExpressionVisitors.add(booleanExpressionVisitor);
	}
	
	public boolean addDivideOperatorExpressionVisitor(DivideOperatorExpressionVisitor<T, R> divideOperatorExpressionVisitor) {
		return this.divideOperatorExpressionVisitors.add(divideOperatorExpressionVisitor);
	}
	
	public boolean addEqualsOperatorExpressionVisitor(EqualsOperatorExpressionVisitor<T, R> equalsOperatorExpressionVisitor) {
		return this.equalsOperatorExpressionVisitors.add(equalsOperatorExpressionVisitor);
	}
	
	public boolean addGreaterThanOperatorExpressionVisitor(GreaterThanOperatorExpressionVisitor<T, R> greaterThanOperatorExpressionVisitor) {
		return this.greaterThanOperatorExpressionVisitors.add(greaterThanOperatorExpressionVisitor);
	}
	
	public boolean addGreaterThanOrEqualToOperatorExpressionVisitor(GreaterThanOrEqualToOperatorExpressionVisitor<T, R> greaterThanOrEqualToOperatorExpressionVisitor) {
		return this.greaterThanOrEqualToOperatorExpressionVisitors.add(greaterThanOrEqualToOperatorExpressionVisitor);
	}
	
	public boolean addImpliesOperatorExpressionVisitor(ImpliesOperatorExpressionVisitor<T, R> impliesOperatorExpressionVisitor) {
		return this.impliesOperatorExpressionVisitors.add(impliesOperatorExpressionVisitor);
	}
	
	public boolean addIntegerExpressionVisitor(IntegerExpressionVisitor<T, R> integerExpressionVisitor) {
		return this.integerExpressionVisitors.add(integerExpressionVisitor);
	}
	
	public boolean addLessThanOperatorExpressionVisitor(LessThanOperatorExpressionVisitor<T, R> lessThanOperatorExpressionVisitor) {
		return this.lessThanOperatorExpressionVisitors.add(lessThanOperatorExpressionVisitor);
	}
	
	public boolean addLessThanOrEqualToOperatorExpressionVisitor(LessThanOrEqualToOperatorExpressionVisitor<T, R> lessThanOrEqualToOperatorExpressionVisitor) {
		return this.lessThanOrEqualToOperatorExpressionVisitors.add(lessThanOrEqualToOperatorExpressionVisitor);
	}
	
	public boolean addMinusOperatorExpressionVisitor(MinusOperatorExpressionVisitor<T, R> minusOperatorExpressionVisitor) {
		return this.minusOperatorExpressionVisitors.add(minusOperatorExpressionVisitor);
	}
	
	public boolean addMultiplyOperatorExpressionVisitor(MultiplyOperatorExpressionVisitor<T, R> multiplyOperatorExpressionVisitor) {
		return this.multiplyOperatorExpressionVisitors.add(multiplyOperatorExpressionVisitor);
	}
	
	public boolean addNegativeOperatorExpressionVisitor(NegativeOperatorExpressionVisitor<T, R> negativeOperatorExpressionVisitor) {
		return this.negativeOperatorExpressionVisitors.add(negativeOperatorExpressionVisitor);
	}
	
	public boolean addNotEqualsOperatorExpressionVisitor(NotEqualsOperatorExpressionVisitor<T, R> notEqualsOperatorExpressionVisitor) {
		return this.notEqualsOperatorExpressionVisitors.add(notEqualsOperatorExpressionVisitor);
	}
	
	public boolean addNotOperatorExpressionVisitor(NotOperatorExpressionVisitor<T, R> notOperatorExpressionVisitor) {
		return this.notOperatorExpressionVisitors.add(notOperatorExpressionVisitor);
	}
	
	public boolean addOrOperatorExpressionVisitor(OrOperatorExpressionVisitor<T, R> orOperatorExpressionVisitor) {
		return this.orOperatorExpressionVisitors.add(orOperatorExpressionVisitor);
	}
	
	public boolean addPlusOperatorExpressionVisitor(PlusOperatorExpressionVisitor<T, R> plusOperatorExpressionVisitor) {
		return this.plusOperatorExpressionVisitors.add(plusOperatorExpressionVisitor);
	}
	
	public boolean addRealExpressionVisitor(RealExpressionVisitor<T, R> realExpressionVisitor) {
		return this.realExpressionVisitors.add(realExpressionVisitor);
	}
	
	public boolean addStringExpressionVisitor(StringExpressionVisitor<T, R> stringExpressionVisitor) {
		return this.stringExpressionVisitors.add(stringExpressionVisitor);
	}
	
	public boolean addXorOperatorExpressionVisitor(XorOperatorExpressionVisitor<T, R> xorOperatorExpressionVisitor) {
		return this.xorOperatorExpressionVisitors.add(xorOperatorExpressionVisitor);
	}
	
	public boolean addSetExpressionVisitor(SetExpressionVisitor<T, R> setExpressionVisitor) {
		return this.setExpressionVisitors.add(setExpressionVisitor);
	}
	
	public boolean addBagExpressionVisitor(BagExpressionVisitor<T, R> bagExpressionVisitor) {
		return this.bagExpressionVisitors.add(bagExpressionVisitor);
	}
	
	public boolean addSequenceExpressionVisitor(SequenceExpressionVisitor<T, R> sequenceExpressionVisitor) {
		return this.sequenceExpressionVisitors.add(sequenceExpressionVisitor);
	}
	
	public boolean addOrderedSetExpressionVisitor(OrderedSetExpressionVisitor<T, R> orderedSetExpressionVisitor) {
		return this.orderedSetExpressionVisitors.add(orderedSetExpressionVisitor);
	}
	
	public boolean addSetTypeVisitor(SetTypeVisitor<T, R> setTypeVisitor) {
		return this.setTypeVisitors.add(setTypeVisitor);
	}
	
	public boolean addSequenceTypeVisitor(SequenceTypeVisitor<T, R> sequenceTypeVisitor) {
		return this.sequenceTypeVisitors.add(sequenceTypeVisitor);
	}
	
	public boolean addBinaryOperatorExpressionVisitor(BinaryOperatorExpressionVisitor<T, R> binaryOperatorExpressionVisitor) {
		return this.binaryOperatorExpressionVisitors.add(binaryOperatorExpressionVisitor);
	}
	
	public boolean addMethodCallExpressionVisitor(MethodCallExpressionVisitor<T, R> methodCallExpressionVisitor) {
		return this.methodCallExpressionVisitors.add(methodCallExpressionVisitor);
	}
	
	public boolean addUnaryOperatorExpressionVisitor(UnaryOperatorExpressionVisitor<T, R> unaryOperatorExpressionVisitor) {
		return this.unaryOperatorExpressionVisitors.add(unaryOperatorExpressionVisitor);
	}
	
	public boolean addPropertyCallExpressionVisitor(PropertyCallExpressionVisitor<T, R> propertyCallExpressionVisitor) {
		return this.propertyCallExpressionVisitors.add(propertyCallExpressionVisitor);
	}
	
	public boolean addFOLMethodCallExpressionVisitor(FOLMethodCallExpressionVisitor<T, R> fOLMethodCallExpressionVisitor) {
		return this.fOLMethodCallExpressionVisitors.add(fOLMethodCallExpressionVisitor);
	}
	
	public boolean addSwitchCaseDefaultStatementVisitor(SwitchCaseDefaultStatementVisitor<T, R> switchCaseDefaultStatementVisitor) {
		return this.switchCaseDefaultStatementVisitors.add(switchCaseDefaultStatementVisitor);
	}
	
	public boolean addSwitchCaseExpressionStatementVisitor(SwitchCaseExpressionStatementVisitor<T, R> switchCaseExpressionStatementVisitor) {
		return this.switchCaseExpressionStatementVisitors.add(switchCaseExpressionStatementVisitor);
	}
	
	public boolean addPrimitiveExpressionVisitor(PrimitiveExpressionVisitor<T, R> primitiveExpressionVisitor) {
		return this.primitiveExpressionVisitors.add(primitiveExpressionVisitor);
	}
	
	public boolean addCollectionExpressionVisitor(CollectionExpressionVisitor<T, R> collectionExpressionVisitor) {
		return this.collectionExpressionVisitors.add(collectionExpressionVisitor);
	}
	
	public boolean addMapExpressionVisitor(MapExpressionVisitor<T, R> mapExpressionVisitor) {
		return this.mapExpressionVisitors.add(mapExpressionVisitor);
	}
	
	public boolean addBooleanTypeVisitor(BooleanTypeVisitor<T, R> booleanTypeVisitor) {
		return this.booleanTypeVisitors.add(booleanTypeVisitor);
	}
	
	public boolean addIntegerTypeVisitor(IntegerTypeVisitor<T, R> integerTypeVisitor) {
		return this.integerTypeVisitors.add(integerTypeVisitor);
	}
	
	public boolean addRealTypeVisitor(RealTypeVisitor<T, R> realTypeVisitor) {
		return this.realTypeVisitors.add(realTypeVisitor);
	}
	
	public boolean addStringTypeVisitor(StringTypeVisitor<T, R> stringTypeVisitor) {
		return this.stringTypeVisitors.add(stringTypeVisitor);
	}
	
	public boolean addBagTypeVisitor(BagTypeVisitor<T, R> bagTypeVisitor) {
		return this.bagTypeVisitors.add(bagTypeVisitor);
	}
	
	public boolean addSpecialNameExpressionVisitor(SpecialNameExpressionVisitor<T, R> specialNameExpressionVisitor) {
		return this.specialNameExpressionVisitors.add(specialNameExpressionVisitor);
	}
	
	public boolean addModelExpressionVisitor(ModelExpressionVisitor<T, R> modelExpressionVisitor) {
		return this.modelExpressionVisitors.add(modelExpressionVisitor);
	}
	
	public boolean addFormalParameterExpressionVisitor(FormalParameterExpressionVisitor<T, R> formalParameterExpressionVisitor) {
		return this.formalParameterExpressionVisitors.add(formalParameterExpressionVisitor);
	}
	
	public boolean addSpecialAssignmentStatementVisitor(SpecialAssignmentStatementVisitor<T, R> specialAssignmentStatementVisitor) {
		return this.specialAssignmentStatementVisitors.add(specialAssignmentStatementVisitor);
	}
	
	public boolean addNativeExpressionVisitor(NativeExpressionVisitor<T, R> nativeExpressionVisitor) {
		return this.nativeExpressionVisitors.add(nativeExpressionVisitor);
	}
	
	public boolean addSelfTypeVisitor(SelfTypeVisitor<T, R> selfTypeVisitor) {
		return this.selfTypeVisitors.add(selfTypeVisitor);
	}
	
	public boolean addSelfContentTypeVisitor(SelfContentTypeVisitor<T, R> selfContentTypeVisitor) {
		return this.selfContentTypeVisitors.add(selfContentTypeVisitor);
	}
	
	public boolean addOrderedCollectionTypeVisitor(OrderedCollectionTypeVisitor<T, R> orderedCollectionTypeVisitor) {
		return this.orderedCollectionTypeVisitors.add(orderedCollectionTypeVisitor);
	}
	
	public boolean addUniqueCollectionTypeVisitor(UniqueCollectionTypeVisitor<T, R> uniqueCollectionTypeVisitor) {
		return this.uniqueCollectionTypeVisitors.add(uniqueCollectionTypeVisitor);
	}
	
	public boolean addSelfInnermostTypeVisitor(SelfInnermostTypeVisitor<T, R> selfInnermostTypeVisitor) {
		return this.selfInnermostTypeVisitors.add(selfInnermostTypeVisitor);
	}
	
	public boolean addOperationArgTypeVisitor(OperationArgTypeVisitor<T, R> operationArgTypeVisitor) {
		return this.operationArgTypeVisitors.add(operationArgTypeVisitor);
	}
	
	public boolean addOperatorExpressionVisitor(OperatorExpressionVisitor<T, R> operatorExpressionVisitor) {
		return this.operatorExpressionVisitors.add(operatorExpressionVisitor);
	}
	
	public boolean addLiteralExpressionVisitor(LiteralExpressionVisitor<T, R> literalExpressionVisitor) {
		return this.literalExpressionVisitors.add(literalExpressionVisitor);
	}
	
	public boolean addEnumerationLiteralExpressionVisitor(EnumerationLiteralExpressionVisitor<T, R> enumerationLiteralExpressionVisitor) {
		return this.enumerationLiteralExpressionVisitors.add(enumerationLiteralExpressionVisitor);
	}
	
	public boolean addFeatureCallExpressionVisitor(FeatureCallExpressionVisitor<T, R> featureCallExpressionVisitor) {
		return this.featureCallExpressionVisitors.add(featureCallExpressionVisitor);
	}
	
	public boolean addNameExpressionVisitor(NameExpressionVisitor<T, R> nameExpressionVisitor) {
		return this.nameExpressionVisitors.add(nameExpressionVisitor);
	}
	
	public boolean addVariableDeclarationExpressionVisitor(VariableDeclarationExpressionVisitor<T, R> variableDeclarationExpressionVisitor) {
		return this.variableDeclarationExpressionVisitors.add(variableDeclarationExpressionVisitor);
	}
	
	public boolean addAssignmentStatementVisitor(AssignmentStatementVisitor<T, R> assignmentStatementVisitor) {
		return this.assignmentStatementVisitors.add(assignmentStatementVisitor);
	}
	
	public boolean addBreakStatementVisitor(BreakStatementVisitor<T, R> breakStatementVisitor) {
		return this.breakStatementVisitors.add(breakStatementVisitor);
	}
	
	public boolean addBreakAllStatementVisitor(BreakAllStatementVisitor<T, R> breakAllStatementVisitor) {
		return this.breakAllStatementVisitors.add(breakAllStatementVisitor);
	}
	
	public boolean addContinueStatementVisitor(ContinueStatementVisitor<T, R> continueStatementVisitor) {
		return this.continueStatementVisitors.add(continueStatementVisitor);
	}
	
	public boolean addDeleteStatementVisitor(DeleteStatementVisitor<T, R> deleteStatementVisitor) {
		return this.deleteStatementVisitors.add(deleteStatementVisitor);
	}
	
	public boolean addForStatementVisitor(ForStatementVisitor<T, R> forStatementVisitor) {
		return this.forStatementVisitors.add(forStatementVisitor);
	}
	
	public boolean addIfStatementVisitor(IfStatementVisitor<T, R> ifStatementVisitor) {
		return this.ifStatementVisitors.add(ifStatementVisitor);
	}
	
	public boolean addReturnStatementVisitor(ReturnStatementVisitor<T, R> returnStatementVisitor) {
		return this.returnStatementVisitors.add(returnStatementVisitor);
	}
	
	public boolean addSwitchStatementVisitor(SwitchStatementVisitor<T, R> switchStatementVisitor) {
		return this.switchStatementVisitors.add(switchStatementVisitor);
	}
	
	public boolean addSwitchCaseStatementVisitor(SwitchCaseStatementVisitor<T, R> switchCaseStatementVisitor) {
		return this.switchCaseStatementVisitors.add(switchCaseStatementVisitor);
	}
	
	public boolean addWhileStatementVisitor(WhileStatementVisitor<T, R> whileStatementVisitor) {
		return this.whileStatementVisitors.add(whileStatementVisitor);
	}
	
	public boolean addModelDeclarationStatementVisitor(ModelDeclarationStatementVisitor<T, R> modelDeclarationStatementVisitor) {
		return this.modelDeclarationStatementVisitors.add(modelDeclarationStatementVisitor);
	}
	
	public boolean addExpressionStatementVisitor(ExpressionStatementVisitor<T, R> expressionStatementVisitor) {
		return this.expressionStatementVisitors.add(expressionStatementVisitor);
	}
	
	public boolean addAnyTypeVisitor(AnyTypeVisitor<T, R> anyTypeVisitor) {
		return this.anyTypeVisitors.add(anyTypeVisitor);
	}
	
	public boolean addCollectionTypeVisitor(CollectionTypeVisitor<T, R> collectionTypeVisitor) {
		return this.collectionTypeVisitors.add(collectionTypeVisitor);
	}
	
	public boolean addPrimitiveTypeVisitor(PrimitiveTypeVisitor<T, R> primitiveTypeVisitor) {
		return this.primitiveTypeVisitors.add(primitiveTypeVisitor);
	}
	
	public boolean addMapTypeVisitor(MapTypeVisitor<T, R> mapTypeVisitor) {
		return this.mapTypeVisitors.add(mapTypeVisitor);
	}
	
	public boolean addExecutableAnnotationVisitor(ExecutableAnnotationVisitor<T, R> executableAnnotationVisitor) {
		return this.executableAnnotationVisitors.add(executableAnnotationVisitor);
	}
	
	public boolean addSimpleAnnotationVisitor(SimpleAnnotationVisitor<T, R> simpleAnnotationVisitor) {
		return this.simpleAnnotationVisitors.add(simpleAnnotationVisitor);
	}
	
	public boolean addModelElementTypeVisitor(ModelElementTypeVisitor<T, R> modelElementTypeVisitor) {
		return this.modelElementTypeVisitors.add(modelElementTypeVisitor);
	}
	
	public boolean addNativeTypeVisitor(NativeTypeVisitor<T, R> nativeTypeVisitor) {
		return this.nativeTypeVisitors.add(nativeTypeVisitor);
	}
	
	public boolean addThrowStatementVisitor(ThrowStatementVisitor<T, R> throwStatementVisitor) {
		return this.throwStatementVisitors.add(throwStatementVisitor);
	}
	
	public boolean addAbortStatementVisitor(AbortStatementVisitor<T, R> abortStatementVisitor) {
		return this.abortStatementVisitors.add(abortStatementVisitor);
	}
	
	public boolean addTransactionStatementVisitor(TransactionStatementVisitor<T, R> transactionStatementVisitor) {
		return this.transactionStatementVisitors.add(transactionStatementVisitor);
	}
	
	public boolean addExprListVisitor(ExprListVisitor<T, R> exprListVisitor) {
		return this.exprListVisitors.add(exprListVisitor);
	}
	
	public boolean addExpRangeVisitor(ExpRangeVisitor<T, R> expRangeVisitor) {
		return this.expRangeVisitors.add(expRangeVisitor);
	}
	
	public boolean addNewExpressionVisitor(NewExpressionVisitor<T, R> newExpressionVisitor) {
		return this.newExpressionVisitors.add(newExpressionVisitor);
	}
	
	public boolean addModelTypeVisitor(ModelTypeVisitor<T, R> modelTypeVisitor) {
		return this.modelTypeVisitors.add(modelTypeVisitor);
	}
	
	public boolean addETypeVisitor(ETypeVisitor<T, R> eTypeVisitor) {
		return this.eTypeVisitors.add(eTypeVisitor);
	}
	
	public boolean addVoidTypeVisitor(VoidTypeVisitor<T, R> voidTypeVisitor) {
		return this.voidTypeVisitors.add(voidTypeVisitor);
	}
	
	public boolean addPseudoTypeVisitor(PseudoTypeVisitor<T, R> pseudoTypeVisitor) {
		return this.pseudoTypeVisitors.add(pseudoTypeVisitor);
	}
	
	public boolean addProgramVisitor(ProgramVisitor<T, R> programVisitor) {
		return this.programVisitors.add(programVisitor);
	}
	
	public boolean addImportVisitor(ImportVisitor<T, R> importVisitor) {
		return this.importVisitors.add(importVisitor);
	}
	
	public boolean addStatementVisitor(StatementVisitor<T, R> statementVisitor) {
		return this.statementVisitors.add(statementVisitor);
	}
	
	public boolean addExpressionVisitor(ExpressionVisitor<T, R> expressionVisitor) {
		return this.expressionVisitors.add(expressionVisitor);
	}
	
	public boolean addBlockVisitor(BlockVisitor<T, R> blockVisitor) {
		return this.blockVisitors.add(blockVisitor);
	}
	
	public boolean addOperationDefinitionVisitor(OperationDefinitionVisitor<T, R> operationDefinitionVisitor) {
		return this.operationDefinitionVisitors.add(operationDefinitionVisitor);
	}
	
	public boolean addTypeVisitor(TypeVisitor<T, R> typeVisitor) {
		return this.typeVisitors.add(typeVisitor);
	}
	
	public boolean addAnnotationVisitor(AnnotationVisitor<T, R> annotationVisitor) {
		return this.annotationVisitors.add(annotationVisitor);
	}
	
	public boolean addKeyValueVisitor(KeyValueVisitor<T, R> keyValueVisitor) {
		return this.keyValueVisitors.add(keyValueVisitor);
	}
	
	public boolean addAnnotationBlockVisitor(AnnotationBlockVisitor<T, R> annotationBlockVisitor) {
		return this.annotationBlockVisitors.add(annotationBlockVisitor);
	}
	
	public boolean addModelDeclarationParameterVisitor(ModelDeclarationParameterVisitor<T, R> modelDeclarationParameterVisitor) {
		return this.modelDeclarationParameterVisitors.add(modelDeclarationParameterVisitor);
	}
	
	public boolean addCollectionInitValueVisitor(CollectionInitValueVisitor<T, R> collectionInitValueVisitor) {
		return this.collectionInitValueVisitors.add(collectionInitValueVisitor);
	}
	
	public boolean addEolElementVisitor(EolElementVisitor<T, R> eolElementVisitor) {
		return this.eolElementVisitors.add(eolElementVisitor);
	}
	
	public boolean addTextRegionVisitor(TextRegionVisitor<T, R> textRegionVisitor) {
		return this.textRegionVisitors.add(textRegionVisitor);
	}
	
	public boolean addTextPositionVisitor(TextPositionVisitor<T, R> textPositionVisitor) {
		return this.textPositionVisitors.add(textPositionVisitor);
	}
	

	public boolean removeOrderedSetTypeVisitor(OrderedSetTypeVisitor<T, R> orderedSetTypeVisitor) {
		return this.orderedSetTypeVisitors.remove(orderedSetTypeVisitor);
	}
	
	public boolean removeAndOperatorExpressionVisitor(AndOperatorExpressionVisitor<T, R> andOperatorExpressionVisitor) {
		return this.andOperatorExpressionVisitors.remove(andOperatorExpressionVisitor);
	}
	
	public boolean removeBooleanExpressionVisitor(BooleanExpressionVisitor<T, R> booleanExpressionVisitor) {
		return this.booleanExpressionVisitors.remove(booleanExpressionVisitor);
	}
	
	public boolean removeDivideOperatorExpressionVisitor(DivideOperatorExpressionVisitor<T, R> divideOperatorExpressionVisitor) {
		return this.divideOperatorExpressionVisitors.remove(divideOperatorExpressionVisitor);
	}
	
	public boolean removeEqualsOperatorExpressionVisitor(EqualsOperatorExpressionVisitor<T, R> equalsOperatorExpressionVisitor) {
		return this.equalsOperatorExpressionVisitors.remove(equalsOperatorExpressionVisitor);
	}
	
	public boolean removeGreaterThanOperatorExpressionVisitor(GreaterThanOperatorExpressionVisitor<T, R> greaterThanOperatorExpressionVisitor) {
		return this.greaterThanOperatorExpressionVisitors.remove(greaterThanOperatorExpressionVisitor);
	}
	
	public boolean removeGreaterThanOrEqualToOperatorExpressionVisitor(GreaterThanOrEqualToOperatorExpressionVisitor<T, R> greaterThanOrEqualToOperatorExpressionVisitor) {
		return this.greaterThanOrEqualToOperatorExpressionVisitors.remove(greaterThanOrEqualToOperatorExpressionVisitor);
	}
	
	public boolean removeImpliesOperatorExpressionVisitor(ImpliesOperatorExpressionVisitor<T, R> impliesOperatorExpressionVisitor) {
		return this.impliesOperatorExpressionVisitors.remove(impliesOperatorExpressionVisitor);
	}
	
	public boolean removeIntegerExpressionVisitor(IntegerExpressionVisitor<T, R> integerExpressionVisitor) {
		return this.integerExpressionVisitors.remove(integerExpressionVisitor);
	}
	
	public boolean removeLessThanOperatorExpressionVisitor(LessThanOperatorExpressionVisitor<T, R> lessThanOperatorExpressionVisitor) {
		return this.lessThanOperatorExpressionVisitors.remove(lessThanOperatorExpressionVisitor);
	}
	
	public boolean removeLessThanOrEqualToOperatorExpressionVisitor(LessThanOrEqualToOperatorExpressionVisitor<T, R> lessThanOrEqualToOperatorExpressionVisitor) {
		return this.lessThanOrEqualToOperatorExpressionVisitors.remove(lessThanOrEqualToOperatorExpressionVisitor);
	}
	
	public boolean removeMinusOperatorExpressionVisitor(MinusOperatorExpressionVisitor<T, R> minusOperatorExpressionVisitor) {
		return this.minusOperatorExpressionVisitors.remove(minusOperatorExpressionVisitor);
	}
	
	public boolean removeMultiplyOperatorExpressionVisitor(MultiplyOperatorExpressionVisitor<T, R> multiplyOperatorExpressionVisitor) {
		return this.multiplyOperatorExpressionVisitors.remove(multiplyOperatorExpressionVisitor);
	}
	
	public boolean removeNegativeOperatorExpressionVisitor(NegativeOperatorExpressionVisitor<T, R> negativeOperatorExpressionVisitor) {
		return this.negativeOperatorExpressionVisitors.remove(negativeOperatorExpressionVisitor);
	}
	
	public boolean removeNotEqualsOperatorExpressionVisitor(NotEqualsOperatorExpressionVisitor<T, R> notEqualsOperatorExpressionVisitor) {
		return this.notEqualsOperatorExpressionVisitors.remove(notEqualsOperatorExpressionVisitor);
	}
	
	public boolean removeNotOperatorExpressionVisitor(NotOperatorExpressionVisitor<T, R> notOperatorExpressionVisitor) {
		return this.notOperatorExpressionVisitors.remove(notOperatorExpressionVisitor);
	}
	
	public boolean removeOrOperatorExpressionVisitor(OrOperatorExpressionVisitor<T, R> orOperatorExpressionVisitor) {
		return this.orOperatorExpressionVisitors.remove(orOperatorExpressionVisitor);
	}
	
	public boolean removePlusOperatorExpressionVisitor(PlusOperatorExpressionVisitor<T, R> plusOperatorExpressionVisitor) {
		return this.plusOperatorExpressionVisitors.remove(plusOperatorExpressionVisitor);
	}
	
	public boolean removeRealExpressionVisitor(RealExpressionVisitor<T, R> realExpressionVisitor) {
		return this.realExpressionVisitors.remove(realExpressionVisitor);
	}
	
	public boolean removeStringExpressionVisitor(StringExpressionVisitor<T, R> stringExpressionVisitor) {
		return this.stringExpressionVisitors.remove(stringExpressionVisitor);
	}
	
	public boolean removeXorOperatorExpressionVisitor(XorOperatorExpressionVisitor<T, R> xorOperatorExpressionVisitor) {
		return this.xorOperatorExpressionVisitors.remove(xorOperatorExpressionVisitor);
	}
	
	public boolean removeSetExpressionVisitor(SetExpressionVisitor<T, R> setExpressionVisitor) {
		return this.setExpressionVisitors.remove(setExpressionVisitor);
	}
	
	public boolean removeBagExpressionVisitor(BagExpressionVisitor<T, R> bagExpressionVisitor) {
		return this.bagExpressionVisitors.remove(bagExpressionVisitor);
	}
	
	public boolean removeSequenceExpressionVisitor(SequenceExpressionVisitor<T, R> sequenceExpressionVisitor) {
		return this.sequenceExpressionVisitors.remove(sequenceExpressionVisitor);
	}
	
	public boolean removeOrderedSetExpressionVisitor(OrderedSetExpressionVisitor<T, R> orderedSetExpressionVisitor) {
		return this.orderedSetExpressionVisitors.remove(orderedSetExpressionVisitor);
	}
	
	public boolean removeSetTypeVisitor(SetTypeVisitor<T, R> setTypeVisitor) {
		return this.setTypeVisitors.remove(setTypeVisitor);
	}
	
	public boolean removeSequenceTypeVisitor(SequenceTypeVisitor<T, R> sequenceTypeVisitor) {
		return this.sequenceTypeVisitors.remove(sequenceTypeVisitor);
	}
	
	public boolean removeBinaryOperatorExpressionVisitor(BinaryOperatorExpressionVisitor<T, R> binaryOperatorExpressionVisitor) {
		return this.binaryOperatorExpressionVisitors.remove(binaryOperatorExpressionVisitor);
	}
	
	public boolean removeMethodCallExpressionVisitor(MethodCallExpressionVisitor<T, R> methodCallExpressionVisitor) {
		return this.methodCallExpressionVisitors.remove(methodCallExpressionVisitor);
	}
	
	public boolean removeUnaryOperatorExpressionVisitor(UnaryOperatorExpressionVisitor<T, R> unaryOperatorExpressionVisitor) {
		return this.unaryOperatorExpressionVisitors.remove(unaryOperatorExpressionVisitor);
	}
	
	public boolean removePropertyCallExpressionVisitor(PropertyCallExpressionVisitor<T, R> propertyCallExpressionVisitor) {
		return this.propertyCallExpressionVisitors.remove(propertyCallExpressionVisitor);
	}
	
	public boolean removeFOLMethodCallExpressionVisitor(FOLMethodCallExpressionVisitor<T, R> fOLMethodCallExpressionVisitor) {
		return this.fOLMethodCallExpressionVisitors.remove(fOLMethodCallExpressionVisitor);
	}
	
	public boolean removeSwitchCaseDefaultStatementVisitor(SwitchCaseDefaultStatementVisitor<T, R> switchCaseDefaultStatementVisitor) {
		return this.switchCaseDefaultStatementVisitors.remove(switchCaseDefaultStatementVisitor);
	}
	
	public boolean removeSwitchCaseExpressionStatementVisitor(SwitchCaseExpressionStatementVisitor<T, R> switchCaseExpressionStatementVisitor) {
		return this.switchCaseExpressionStatementVisitors.remove(switchCaseExpressionStatementVisitor);
	}
	
	public boolean removePrimitiveExpressionVisitor(PrimitiveExpressionVisitor<T, R> primitiveExpressionVisitor) {
		return this.primitiveExpressionVisitors.remove(primitiveExpressionVisitor);
	}
	
	public boolean removeCollectionExpressionVisitor(CollectionExpressionVisitor<T, R> collectionExpressionVisitor) {
		return this.collectionExpressionVisitors.remove(collectionExpressionVisitor);
	}
	
	public boolean removeMapExpressionVisitor(MapExpressionVisitor<T, R> mapExpressionVisitor) {
		return this.mapExpressionVisitors.remove(mapExpressionVisitor);
	}
	
	public boolean removeBooleanTypeVisitor(BooleanTypeVisitor<T, R> booleanTypeVisitor) {
		return this.booleanTypeVisitors.remove(booleanTypeVisitor);
	}
	
	public boolean removeIntegerTypeVisitor(IntegerTypeVisitor<T, R> integerTypeVisitor) {
		return this.integerTypeVisitors.remove(integerTypeVisitor);
	}
	
	public boolean removeRealTypeVisitor(RealTypeVisitor<T, R> realTypeVisitor) {
		return this.realTypeVisitors.remove(realTypeVisitor);
	}
	
	public boolean removeStringTypeVisitor(StringTypeVisitor<T, R> stringTypeVisitor) {
		return this.stringTypeVisitors.remove(stringTypeVisitor);
	}
	
	public boolean removeBagTypeVisitor(BagTypeVisitor<T, R> bagTypeVisitor) {
		return this.bagTypeVisitors.remove(bagTypeVisitor);
	}
	
	public boolean removeSpecialNameExpressionVisitor(SpecialNameExpressionVisitor<T, R> specialNameExpressionVisitor) {
		return this.specialNameExpressionVisitors.remove(specialNameExpressionVisitor);
	}
	
	public boolean removeModelExpressionVisitor(ModelExpressionVisitor<T, R> modelExpressionVisitor) {
		return this.modelExpressionVisitors.remove(modelExpressionVisitor);
	}
	
	public boolean removeFormalParameterExpressionVisitor(FormalParameterExpressionVisitor<T, R> formalParameterExpressionVisitor) {
		return this.formalParameterExpressionVisitors.remove(formalParameterExpressionVisitor);
	}
	
	public boolean removeSpecialAssignmentStatementVisitor(SpecialAssignmentStatementVisitor<T, R> specialAssignmentStatementVisitor) {
		return this.specialAssignmentStatementVisitors.remove(specialAssignmentStatementVisitor);
	}
	
	public boolean removeNativeExpressionVisitor(NativeExpressionVisitor<T, R> nativeExpressionVisitor) {
		return this.nativeExpressionVisitors.remove(nativeExpressionVisitor);
	}
	
	public boolean removeSelfTypeVisitor(SelfTypeVisitor<T, R> selfTypeVisitor) {
		return this.selfTypeVisitors.remove(selfTypeVisitor);
	}
	
	public boolean removeSelfContentTypeVisitor(SelfContentTypeVisitor<T, R> selfContentTypeVisitor) {
		return this.selfContentTypeVisitors.remove(selfContentTypeVisitor);
	}
	
	public boolean removeOrderedCollectionTypeVisitor(OrderedCollectionTypeVisitor<T, R> orderedCollectionTypeVisitor) {
		return this.orderedCollectionTypeVisitors.remove(orderedCollectionTypeVisitor);
	}
	
	public boolean removeUniqueCollectionTypeVisitor(UniqueCollectionTypeVisitor<T, R> uniqueCollectionTypeVisitor) {
		return this.uniqueCollectionTypeVisitors.remove(uniqueCollectionTypeVisitor);
	}
	
	public boolean removeSelfInnermostTypeVisitor(SelfInnermostTypeVisitor<T, R> selfInnermostTypeVisitor) {
		return this.selfInnermostTypeVisitors.remove(selfInnermostTypeVisitor);
	}
	
	public boolean removeOperationArgTypeVisitor(OperationArgTypeVisitor<T, R> operationArgTypeVisitor) {
		return this.operationArgTypeVisitors.remove(operationArgTypeVisitor);
	}
	
	public boolean removeOperatorExpressionVisitor(OperatorExpressionVisitor<T, R> operatorExpressionVisitor) {
		return this.operatorExpressionVisitors.remove(operatorExpressionVisitor);
	}
	
	public boolean removeLiteralExpressionVisitor(LiteralExpressionVisitor<T, R> literalExpressionVisitor) {
		return this.literalExpressionVisitors.remove(literalExpressionVisitor);
	}
	
	public boolean removeEnumerationLiteralExpressionVisitor(EnumerationLiteralExpressionVisitor<T, R> enumerationLiteralExpressionVisitor) {
		return this.enumerationLiteralExpressionVisitors.remove(enumerationLiteralExpressionVisitor);
	}
	
	public boolean removeFeatureCallExpressionVisitor(FeatureCallExpressionVisitor<T, R> featureCallExpressionVisitor) {
		return this.featureCallExpressionVisitors.remove(featureCallExpressionVisitor);
	}
	
	public boolean removeNameExpressionVisitor(NameExpressionVisitor<T, R> nameExpressionVisitor) {
		return this.nameExpressionVisitors.remove(nameExpressionVisitor);
	}
	
	public boolean removeVariableDeclarationExpressionVisitor(VariableDeclarationExpressionVisitor<T, R> variableDeclarationExpressionVisitor) {
		return this.variableDeclarationExpressionVisitors.remove(variableDeclarationExpressionVisitor);
	}
	
	public boolean removeAssignmentStatementVisitor(AssignmentStatementVisitor<T, R> assignmentStatementVisitor) {
		return this.assignmentStatementVisitors.remove(assignmentStatementVisitor);
	}
	
	public boolean removeBreakStatementVisitor(BreakStatementVisitor<T, R> breakStatementVisitor) {
		return this.breakStatementVisitors.remove(breakStatementVisitor);
	}
	
	public boolean removeBreakAllStatementVisitor(BreakAllStatementVisitor<T, R> breakAllStatementVisitor) {
		return this.breakAllStatementVisitors.remove(breakAllStatementVisitor);
	}
	
	public boolean removeContinueStatementVisitor(ContinueStatementVisitor<T, R> continueStatementVisitor) {
		return this.continueStatementVisitors.remove(continueStatementVisitor);
	}
	
	public boolean removeDeleteStatementVisitor(DeleteStatementVisitor<T, R> deleteStatementVisitor) {
		return this.deleteStatementVisitors.remove(deleteStatementVisitor);
	}
	
	public boolean removeForStatementVisitor(ForStatementVisitor<T, R> forStatementVisitor) {
		return this.forStatementVisitors.remove(forStatementVisitor);
	}
	
	public boolean removeIfStatementVisitor(IfStatementVisitor<T, R> ifStatementVisitor) {
		return this.ifStatementVisitors.remove(ifStatementVisitor);
	}
	
	public boolean removeReturnStatementVisitor(ReturnStatementVisitor<T, R> returnStatementVisitor) {
		return this.returnStatementVisitors.remove(returnStatementVisitor);
	}
	
	public boolean removeSwitchStatementVisitor(SwitchStatementVisitor<T, R> switchStatementVisitor) {
		return this.switchStatementVisitors.remove(switchStatementVisitor);
	}
	
	public boolean removeSwitchCaseStatementVisitor(SwitchCaseStatementVisitor<T, R> switchCaseStatementVisitor) {
		return this.switchCaseStatementVisitors.remove(switchCaseStatementVisitor);
	}
	
	public boolean removeWhileStatementVisitor(WhileStatementVisitor<T, R> whileStatementVisitor) {
		return this.whileStatementVisitors.remove(whileStatementVisitor);
	}
	
	public boolean removeModelDeclarationStatementVisitor(ModelDeclarationStatementVisitor<T, R> modelDeclarationStatementVisitor) {
		return this.modelDeclarationStatementVisitors.remove(modelDeclarationStatementVisitor);
	}
	
	public boolean removeExpressionStatementVisitor(ExpressionStatementVisitor<T, R> expressionStatementVisitor) {
		return this.expressionStatementVisitors.remove(expressionStatementVisitor);
	}
	
	public boolean removeAnyTypeVisitor(AnyTypeVisitor<T, R> anyTypeVisitor) {
		return this.anyTypeVisitors.remove(anyTypeVisitor);
	}
	
	public boolean removeCollectionTypeVisitor(CollectionTypeVisitor<T, R> collectionTypeVisitor) {
		return this.collectionTypeVisitors.remove(collectionTypeVisitor);
	}
	
	public boolean removePrimitiveTypeVisitor(PrimitiveTypeVisitor<T, R> primitiveTypeVisitor) {
		return this.primitiveTypeVisitors.remove(primitiveTypeVisitor);
	}
	
	public boolean removeMapTypeVisitor(MapTypeVisitor<T, R> mapTypeVisitor) {
		return this.mapTypeVisitors.remove(mapTypeVisitor);
	}
	
	public boolean removeExecutableAnnotationVisitor(ExecutableAnnotationVisitor<T, R> executableAnnotationVisitor) {
		return this.executableAnnotationVisitors.remove(executableAnnotationVisitor);
	}
	
	public boolean removeSimpleAnnotationVisitor(SimpleAnnotationVisitor<T, R> simpleAnnotationVisitor) {
		return this.simpleAnnotationVisitors.remove(simpleAnnotationVisitor);
	}
	
	public boolean removeModelElementTypeVisitor(ModelElementTypeVisitor<T, R> modelElementTypeVisitor) {
		return this.modelElementTypeVisitors.remove(modelElementTypeVisitor);
	}
	
	public boolean removeNativeTypeVisitor(NativeTypeVisitor<T, R> nativeTypeVisitor) {
		return this.nativeTypeVisitors.remove(nativeTypeVisitor);
	}
	
	public boolean removeThrowStatementVisitor(ThrowStatementVisitor<T, R> throwStatementVisitor) {
		return this.throwStatementVisitors.remove(throwStatementVisitor);
	}
	
	public boolean removeAbortStatementVisitor(AbortStatementVisitor<T, R> abortStatementVisitor) {
		return this.abortStatementVisitors.remove(abortStatementVisitor);
	}
	
	public boolean removeTransactionStatementVisitor(TransactionStatementVisitor<T, R> transactionStatementVisitor) {
		return this.transactionStatementVisitors.remove(transactionStatementVisitor);
	}
	
	public boolean removeExprListVisitor(ExprListVisitor<T, R> exprListVisitor) {
		return this.exprListVisitors.remove(exprListVisitor);
	}
	
	public boolean removeExpRangeVisitor(ExpRangeVisitor<T, R> expRangeVisitor) {
		return this.expRangeVisitors.remove(expRangeVisitor);
	}
	
	public boolean removeNewExpressionVisitor(NewExpressionVisitor<T, R> newExpressionVisitor) {
		return this.newExpressionVisitors.remove(newExpressionVisitor);
	}
	
	public boolean removeModelTypeVisitor(ModelTypeVisitor<T, R> modelTypeVisitor) {
		return this.modelTypeVisitors.remove(modelTypeVisitor);
	}
	
	public boolean removeETypeVisitor(ETypeVisitor<T, R> eTypeVisitor) {
		return this.eTypeVisitors.remove(eTypeVisitor);
	}
	
	public boolean removeVoidTypeVisitor(VoidTypeVisitor<T, R> voidTypeVisitor) {
		return this.voidTypeVisitors.remove(voidTypeVisitor);
	}
	
	public boolean removePseudoTypeVisitor(PseudoTypeVisitor<T, R> pseudoTypeVisitor) {
		return this.pseudoTypeVisitors.remove(pseudoTypeVisitor);
	}
	
	public boolean removeProgramVisitor(ProgramVisitor<T, R> programVisitor) {
		return this.programVisitors.remove(programVisitor);
	}
	
	public boolean removeImportVisitor(ImportVisitor<T, R> importVisitor) {
		return this.importVisitors.remove(importVisitor);
	}
	
	public boolean removeStatementVisitor(StatementVisitor<T, R> statementVisitor) {
		return this.statementVisitors.remove(statementVisitor);
	}
	
	public boolean removeExpressionVisitor(ExpressionVisitor<T, R> expressionVisitor) {
		return this.expressionVisitors.remove(expressionVisitor);
	}
	
	public boolean removeBlockVisitor(BlockVisitor<T, R> blockVisitor) {
		return this.blockVisitors.remove(blockVisitor);
	}
	
	public boolean removeOperationDefinitionVisitor(OperationDefinitionVisitor<T, R> operationDefinitionVisitor) {
		return this.operationDefinitionVisitors.remove(operationDefinitionVisitor);
	}
	
	public boolean removeTypeVisitor(TypeVisitor<T, R> typeVisitor) {
		return this.typeVisitors.remove(typeVisitor);
	}
	
	public boolean removeAnnotationVisitor(AnnotationVisitor<T, R> annotationVisitor) {
		return this.annotationVisitors.remove(annotationVisitor);
	}
	
	public boolean removeKeyValueVisitor(KeyValueVisitor<T, R> keyValueVisitor) {
		return this.keyValueVisitors.remove(keyValueVisitor);
	}
	
	public boolean removeAnnotationBlockVisitor(AnnotationBlockVisitor<T, R> annotationBlockVisitor) {
		return this.annotationBlockVisitors.remove(annotationBlockVisitor);
	}
	
	public boolean removeModelDeclarationParameterVisitor(ModelDeclarationParameterVisitor<T, R> modelDeclarationParameterVisitor) {
		return this.modelDeclarationParameterVisitors.remove(modelDeclarationParameterVisitor);
	}
	
	public boolean removeCollectionInitValueVisitor(CollectionInitValueVisitor<T, R> collectionInitValueVisitor) {
		return this.collectionInitValueVisitors.remove(collectionInitValueVisitor);
	}
	
	public boolean removeEolElementVisitor(EolElementVisitor<T, R> eolElementVisitor) {
		return this.eolElementVisitors.remove(eolElementVisitor);
	}
	
	public boolean removeTextRegionVisitor(TextRegionVisitor<T, R> textRegionVisitor) {
		return this.textRegionVisitors.remove(textRegionVisitor);
	}
	
	public boolean removeTextPositionVisitor(TextPositionVisitor<T, R> textPositionVisitor) {
		return this.textPositionVisitors.remove(textPositionVisitor);
	}
	
	
	
	public boolean addDefaultVisitor(EolDefaultVisitor<T, R> defaultVisitor) {
		return this.defaultVisitors.add(defaultVisitor);
	}
	
	public boolean removeDefaultVisitor(EolDefaultVisitor<T, R> defaultVisitor) {
		return this.defaultVisitors.remove(defaultVisitor);
	}
}