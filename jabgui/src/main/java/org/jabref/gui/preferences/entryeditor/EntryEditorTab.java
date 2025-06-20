package org.jabref.gui.preferences.entryeditor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

import org.jabref.gui.actions.ActionFactory;
import org.jabref.gui.actions.StandardActions;
import org.jabref.gui.help.HelpAction;
import org.jabref.gui.preferences.AbstractPreferenceTabView;
import org.jabref.gui.preferences.PreferencesTab;
import org.jabref.logic.help.HelpFile;
import org.jabref.logic.l10n.Localization;

import com.airhacks.afterburner.views.ViewLoader;

public class EntryEditorTab extends AbstractPreferenceTabView<EntryEditorTabViewModel> implements PreferencesTab {

    @FXML private CheckBox openOnNewEntry;
    @FXML private CheckBox defaultSource;
    @FXML private CheckBox enableRelatedArticlesTab;
    @FXML private CheckBox enableAiSummaryTab;
    @FXML private CheckBox enableAiChatTab;
    @FXML private CheckBox acceptRecommendations;
    @FXML private CheckBox enableLatexCitationsTab;
    @FXML private CheckBox enableFileAnnotationsTab;
    @FXML private CheckBox enableValidation;
    @FXML private CheckBox allowIntegerEdition;
    @FXML private CheckBox journalPopupEnabled;
    @FXML private CheckBox autoLinkFilesEnabled;
    @FXML private CheckBox enableSciteTab;
    @FXML private CheckBox showUserCommentsField;

    @FXML private Button generalFieldsHelp;
    @FXML private TextArea fieldsTextArea;

    public EntryEditorTab() {
        ViewLoader.view(this)
                  .root(this)
                  .load();
    }

    @Override
    public String getTabName() {
        return Localization.lang("Entry editor");
    }

    public void initialize() {
        this.viewModel = new EntryEditorTabViewModel(dialogService, preferences);

        openOnNewEntry.selectedProperty().bindBidirectional(viewModel.openOnNewEntryProperty());
        defaultSource.selectedProperty().bindBidirectional(viewModel.defaultSourceProperty());
        enableRelatedArticlesTab.selectedProperty().bindBidirectional(viewModel.enableRelatedArticlesTabProperty());
        enableAiSummaryTab.selectedProperty().bindBidirectional(viewModel.enableAiSummaryTabProperty());
        enableAiChatTab.selectedProperty().bindBidirectional(viewModel.enableAiChatTabProperty());
        acceptRecommendations.selectedProperty().bindBidirectional(viewModel.acceptRecommendationsProperty());
        enableLatexCitationsTab.selectedProperty().bindBidirectional(viewModel.enableLatexCitationsTabProperty());
        enableFileAnnotationsTab.selectedProperty().bindBidirectional(viewModel.enableFileAnnotationsTabProperty());
        enableValidation.selectedProperty().bindBidirectional(viewModel.enableValidationProperty());
        allowIntegerEdition.selectedProperty().bindBidirectional(viewModel.allowIntegerEditionProperty());
        journalPopupEnabled.selectedProperty().bindBidirectional(viewModel.journalPopupProperty());
        autoLinkFilesEnabled.selectedProperty().bindBidirectional(viewModel.autoLinkFilesEnabledProperty());
        enableSciteTab.selectedProperty().bindBidirectional(viewModel.enableSciteTabProperty());
        showUserCommentsField.selectedProperty().bindBidirectional(viewModel.showUserCommentsProperty());

        fieldsTextArea.textProperty().bindBidirectional(viewModel.fieldsProperty());

        ActionFactory actionFactory = new ActionFactory();
        actionFactory.configureIconButton(StandardActions.HELP, new HelpAction(HelpFile.GENERAL_FIELDS, dialogService, preferences.getExternalApplicationsPreferences()), generalFieldsHelp);
    }

    @FXML
    void resetToDefaults() {
        viewModel.resetToDefaults();
    }
}
